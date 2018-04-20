package com.xrom.server.service.impl;

import com.xrom.server.entity.User;
import com.xrom.server.mapper.UserMapper;
import com.xrom.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: XRom
 * @date: 2018-04-16 15:49:02
 * 用户业务逻辑编写
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户id获取用户信息
     * @param id    用户id
     * @return  用户实体
     */
    @Override
    public User selectById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
