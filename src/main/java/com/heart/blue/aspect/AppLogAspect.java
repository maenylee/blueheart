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
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


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
        this.saveLogInfo(startTime,endTime,appLogInfo,errorMessage);
        return result;
    }

    /**
     * 保存日志信息
     * @param startTime   方法执行之前时间
     * @param endTime     方法执行之后时间
     * @param appLogInfo  注解实例对象
     */
    public void saveLogInfo(Long startTime,Long endTime,AppLogInfo appLogInfo,String errorMessage){
        Log log = new Log();
        //执行时间秒数
        Long duration = (endTime - startTime)/1000;
        //方法描述
        String methodDesc = appLogInfo.value();
    }

}