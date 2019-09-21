package com.heart.blue.manage.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.heart.blue.manage.dao.SysUserMapper;
import com.heart.blue.manage.entity.SysUser;
import com.heart.blue.manage.service.ISysUserService;
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
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    /**
     * 分页查询用户信息
     * @param page
     * @return
     */
    @Override
    public Page<SysUser> selectUserWithPage(Page<SysUser> page,EntityWrapper<SysUser> entityWrapper) {
        return this.selectPage(page,new EntityWrapper<>());
    }
}
