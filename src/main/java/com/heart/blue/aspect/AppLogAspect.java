/**
 * FileName: AppLogAspect
 * Author:   Danny
 * Date:     2019/11/2 14:25
 * Description: 日志切面类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heart.blue.aspect;

import com.heart.blue.annotation.AppLogInfo;
import com.heart.blue.manage.entity.Log;
import com.heart.blue.manage.service.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;


/**
 * 〈一句话功能简述〉<br> 
 * 〈日志切面类〉
 *
 * @author Danny
 * @create 2019/11/2
 * @since 1.0.0
 */
@Aspect
@Component
public class AppLogAspect {

    @Autowired
    private ILogService logService;

    private Logger logger = LoggerFactory.getLogger(AppLogAspect.class);

    /**
     * 根据注解进行切面，不获取注解实例
     */
    @Pointcut("@annotation(com.heart.blue.annotation.AppLogInfo)")
    public void logInfo(){}

    /**
     *根据注解进行切面，同时获取注解实例
     * @param point
     * @param appLogInfo 切点的注解示例，可以从注解中拿到切点注解的配置
     */
    @Around("@annotation(appLogInfo)")
    public Object appLogInfo(ProceedingJoinPoint point, AppLogInfo appLogInfo){
        //方法执行前
        Long startTime = System.currentTimeMillis();
        //执行方法
        Object result = null;
        String errorMessage = "";
        try {
            result = point.proceed();
        }catch (Throwable e){
            errorMessage = e.getMessage();
        }
        //方法执行后
        Long endTime = System.currentTimeMillis();
        this.saveLogInfo(startTime,endTime,appLogInfo,errorMessage,point);
        return result;
    }

    /**
     * 保存日志信息
     * @param startTime   方法执行之前时间
     * @param endTime     方法执行之后时间
     * @param appLogInfo  注解实例对象
     */
    public void saveLogInfo(Long startTime,Long endTime,AppLogInfo appLogInfo,String errorMessage,ProceedingJoinPoint point){
        Log log = new Log();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取请求路径
        String requestUrl = request.getServletPath();
        //获取请求主机IP
        String ipAddr = request.getRemoteAddr();
        //执行时间秒数
        Long duration = (endTime - startTime)/1000;
        //方法描述
        String methodDesc = appLogInfo.value();
        //获取方法请求参数
        Object[] params = point.getArgs();
        System.err.println(Arrays.toString(params));
        //获取类名称
        String className = point.getTarget().getClass().getName();
        //获取方法名称
        String methodName = point.getSignature().getName();
        log.setErrorMessage(errorMessage).
                setExecTime(duration.intValue())
                .setGmtCreate(new Date())
                .setMethodDesc(methodDesc)
                .setMethodName(methodName)
                .setRequestIp(ipAddr).setRequestUrl(requestUrl)
                .setRequestParam(Arrays.toString(params));
        try {
            logService.insert(log);
        }catch (Exception e){
            logger.error("操作日志添加异常！错误信息：{}",e.getMessage());
        }
    }

}