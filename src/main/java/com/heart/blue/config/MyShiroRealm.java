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
import com.heart.blue.manage.entity.SysRole;
import com.heart.blue.manage.entity.SysUser;
import com.heart.blue.manage.service.ISysPermissionService;
import com.heart.blue.manage.service.ISysRoleService;
import com.heart.blue.manage.service.ISysUserService;
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
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysPermissionService sysPermissionService;

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
        SysUser user = (SysUser) ShiroUtils.getAttribute("user");
        //根据用户ID获取用户角色标识
        List<SysRole> sysRoles = sysRoleService.listRoles(user.getId());
        List<String> roleTypes = sysRoles.stream().map(item->item.getRoleType()).collect(Collectors.toList());
        System.err.println(roleTypes.toString());
        simpleAuthorizationInfo.addRoles(roleTypes);
        //根据角色获取用户权限标识
        List<Integer> roleIds = sysRoles.stream().map(item->item.getId()).collect(Collectors.toList());
        List<String> permTypes = sysPermissionService.listPermType(roleIds);
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
        SysUser user = sysUserService.selectOne(new EntityWrapper<SysUser>().eq(SysUser.USER_NAME,account));
        if(user != null){
            ShiroUtils.setAttribute("user",user);
            return new SimpleAuthenticationInfo(account,user.getPassword(),getName());
        }else{
            System.err.println("认证失败");
            return null;
        }
    }
}