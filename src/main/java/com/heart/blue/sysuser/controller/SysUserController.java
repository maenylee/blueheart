/**
 * FileName: UserController
 * Author:   Danny
 * Date:     2019/8/23 15:16
 * Description: 前端控制器：用户操作接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heart.blue.sysuser.controller;

import com.heart.blue.sysuser.entity.SysUser;
import com.heart.blue.sysuser.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈前端控制器：用户操作接口〉
 *
 * @author Danny
 * @create 2019/8/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询用户信息列表
     * @return
     */
    @RequestMapping(value = "/searchUserList",method = RequestMethod.GET)
    public String searchUserList(){
        List<SysUser> list = sysUserService.list();
        System.err.println(list.toString());
        return "userList";
    }
}