package com.heart.blue.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heart.blue.manage.dao.SysRoleMapper;
import com.heart.blue.manage.entity.SysRole;
import com.heart.blue.manage.service.ISysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  角色服务实现类
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    /**
     * 查询用户角色标识
     * @param userId
     * @return
     */
    @Override
    public List<SysRole> listRoles(Integer userId) {
        return baseMapper.selectRoleTypes(userId);
    }
}
