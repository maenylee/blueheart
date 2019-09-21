package com.heart.blue.manage.service;


import com.baomidou.mybatisplus.service.IService;
import com.heart.blue.manage.entity.SysPermission;

import java.util.List;

/**
 * <p>
 *  权限服务接口
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
public interface ISysPermissionService extends IService<SysPermission> {
    /**
     * 根据角色查询权限菜单标识
     * @param roleId
     * @return
     */
    List<String> listPermType(List<Integer> roleId);
}
