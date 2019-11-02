/**
 * FileName: UserController
 * Author:   Danny
 * Date:     2019/8/23 15:16
 * Description: 前端控制器：用户操作接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heart.blue.manage.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.heart.blue.manage.entity.User;
import com.heart.blue.manage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 〈一句话功能简述〉<br> 
 * 〈前端控制器：用户操作接口〉
 *
 * @author Danny
 * @create 2019/8/23
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 分页查询用户信息列表
     * @return
     */
    @RequestMapping(value = "/searchUserList",method = RequestMethod.GET)
    public String searchUserList(){
        Page<User> page = new Page<User>();
        page = userService.selectUserWithPage(page,new EntityWrapper<>());
        System.err.println(page.getRecords());
        return "userList";
    }
}