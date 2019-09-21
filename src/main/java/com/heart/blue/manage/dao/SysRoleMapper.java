package com.heart.blue.manage.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.heart.blue.manage.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 查询用户角色标识
     * @param userId
     * @return
     */
    List<SysRole> selectRoleTypes(Integer userId);
}
