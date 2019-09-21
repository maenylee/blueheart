package com.heart.blue.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heart.blue.manage.dao.SysPermissionMapper;
import com.heart.blue.manage.entity.SysPermission;
import com.heart.blue.manage.service.ISysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  权限服务实现类
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {
    /**
     * 根据角色查询权限菜单标识
     * @param roleId
     * @return
     */
    @Override
    public List<String> listPermType(List<Integer> roleId) {
        return baseMapper.selectPermTypes(roleId);
    }
}
