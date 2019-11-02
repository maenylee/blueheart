package com.heart.blue.manage.service;


import com.baomidou.mybatisplus.service.IService;
import com.heart.blue.manage.entity.Role;

import java.util.List;

/**
 * <p>
 *  角色服务接口
 * </p>
 *
 * @author Danny
 * @since 2019-09-21
 */
public interface IRoleService extends IService<Role> {
    /**
     * 查询用户角色标识
     * @param userId
     * @return
     */
    List<Role> listRoles(Integer userId);
}
