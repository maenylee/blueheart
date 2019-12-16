/**
 * FileName: MyShiroRealm
 * Author:   Danny
 * Date:     2019/9/20 13:45
 * Description: 用户登录认证授权域
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.heart.blue.config;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.heart.blue.manage.entity.Role;
import com.heart.blue.manage.entity.User;
import com.heart.blue.manage.service.IPermissionService;
import com.heart.blue.manage.service.IRoleService;
import com.heart.blue.manage.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户登录认证授权域〉
 *
 * @author Danny
 * @create 2019/9/20
 * @since 1.0.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.err.println("授权中...");
        //创建授权信息对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取当前用户
        User user = (User) ShiroUtils.getAttribute("user");
        //根据用户ID获取用户角色标识
        List<Role> sysRoles = roleService.listRoles(user.getId());
        //用户无角色，未授权
        if(sysRoles.size() == 0){
            return simpleAuthorizationInfo;
        }
        List<String> roleTypes = sysRoles.stream().map(item->item.getRoleType()).collect(Collectors.toList());
        System.err.println(roleTypes.toString());
        simpleAuthorizationInfo.addRoles(roleTypes);
        //根据角色获取用户权限标识
        List<Integer> roleIds = sysRoles.stream().map(item->item.getId()).collect(Collectors.toList());
        List<String> permTypes = permissionService.listPermType(roleIds);
        System.err.println(permTypes.toString());
        simpleAuthorizationInfo.addStringPermissions(permTypes);
        return simpleAuthorizationInfo;
    }

    /**
     * 身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.err.println("认证中...");
        UsernamePasswordToken upt = (UsernamePasswordToken)token;
        String account = upt.getUsername();
        User user = userService.selectOne(new EntityWrapper<User>().eq(User.USER_NAME,account));
        if(user != null){
            ShiroUtils.setAttribute("user",user);
            return new SimpleAuthenticationInfo(account,user.getPassword(),getName());
        }else{
            System.err.println("认证失败");
            return null;
        }
    }
}