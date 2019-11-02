package com.heart.blue.manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heart.blue.manage.dao.UserMapper;
import com.heart.blue.manage.entity.User;
import com.heart.blue.manage.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  用户服务实现类
 * </p>
 *
 * @author Danny
 * @since 2019-08-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    /**
     * 分页查询用户信息
     * @param page
     * @return
     */
    @Override
    public Page<User> selectUserWithPage(Page<User> page, EntityWrapper<User> entityWrapper) {
        return this.selectPage(page,new EntityWrapper<>());
    }
}
