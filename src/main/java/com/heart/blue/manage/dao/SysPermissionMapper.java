package com.heart.blue.manage.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.heart.blue.manage.entity.SysPermission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    /**
     * 根据角色查询权限菜单标识
     * @param roleIds
     * @return
     */
    List<String> selectPermTypes(List<Integer> roleIds);
}
