/**
 * FileName: ShiroUtils
 * Author:   Danny
 * Date:     2019/9/21 10:57
 * Description: shiro相关工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heart.blue.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * 〈一句话功能简述〉<br> 
 * 〈shiro相关工具类〉
 *
 * @author Danny
 * @create 2019/9/21
 * @since 1.0.0
 */
public class ShiroUtils {
    /**
     * 获取session
     * @return
     */
    public static Session getShiroSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取session属性的值
     * @param key
     * @return
     */
    public static Object getAttribute(Object key){
        return getShiroSession().getAttribute(key);
    }

    /**
     * 保存属性值到session中
     * @param key
     * @param value
     */
    public static void setAttribute(Object key,Object value){
        getShiroSession().setAttribute(key,value);
    }
}