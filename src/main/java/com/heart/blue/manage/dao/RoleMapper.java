package com.heart.blue.manage.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.heart.blue.manage.entity.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询用户角色标识
     * @param userId
     * @return
     */
    List<Role> selectRoleTypes(Integer userId);
}
