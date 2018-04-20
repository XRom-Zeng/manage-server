package com.xrom.server.service;


import com.xrom.server.entity.User;

/**
 * @author: XRom
 * @date: 2018-04-16 15:48:21
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param id    用户id
     * @return  用户实体
     */
    User selectById(Long id);
}
