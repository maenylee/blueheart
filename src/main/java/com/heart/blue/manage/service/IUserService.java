package com.heart.blue.manage.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.heart.blue.manage.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Danny
 * @since 2019-08-23
 */
public interface IUserService extends IService<User> {
    /**
     * 分页查询用户信息
     * @param page
     * @return
     */
    Page<User> selectUserWithPage(Page<User> page, EntityWrapper<User> entityWrapper);
}
