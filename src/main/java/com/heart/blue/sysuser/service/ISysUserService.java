package com.heart.blue.sysuser.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.heart.blue.sysuser.entity.SysUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Danny
 * @since 2019-08-23
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 分页查询用户信息
     * @param page
     * @return
     */
    Page<SysUser> selectUserWithPage(Page<SysUser> page, EntityWrapper<SysUser> entityWrapper);
}
