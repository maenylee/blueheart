/**
 * FileName: LoginController
 * Author:   Danny
 * Date:     2019/9/20 13:27
 * Description: 前端控制器：登录注册相关接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heart.blue.manage.controller;

import com.heart.blue.annotation.AppLogInfo;
import com.heart.blue.config.ShiroUtils;
import com.heart.blue.manage.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 〈一句话功能简述〉<br> 
 * 〈前端控制器：登录注册相关接口〉
 *
 * @author Danny
 * @create 2019/9/20
 * @since 1.0.0
 */
@Controller
public class LoginController {


    @RequestMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }

    @RequiresPermissions(value = {"sys:manage"})
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        //获取用户信息
        User sysUser = (User) ShiroUtils.getAttribute("user");
        mv.setViewName("index");
        mv.addObject("user",sysUser);
        return mv;
    }

    @AppLogInfo("登录接口")
    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public String doLogin(String username, String password){
        System.err.println("登录中...");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            System.err.println("认证成功");
            return "redirect:/index";
        }catch (Exception e){
            System.err.println("认证失败！");
        }
        return "redirect:/login";
    }

}