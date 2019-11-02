package com.heart.blue.manage.service.impl;

import com.heart.blue.manage.dao.LogMapper;
import com.heart.blue.manage.entity.Log;
import com.heart.blue.manage.service.ILogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Danny
 * @since 2019-11-02
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

}
