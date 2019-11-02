package com.heart.blue.manage.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heart.blue.manage.dao.RoleMapper;
import com.heart.blue.manage.entity.Role;
import com.heart.blue.manage.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    /**
     * 查询用户角色标识
     * @param userId
     * @return
     */
    @Override
    public List<Role> listRoles(Integer userId) {
        return baseMapper.selectRoleTypes(userId);
    }
}
