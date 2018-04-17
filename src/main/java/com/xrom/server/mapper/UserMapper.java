package com.xrom.server.mapper;

import com.xrom.server.entity.User;

/**
 * @author: XRom
 * @date: 2018-04-16 15:38:29
 */
public interface UserMapper {

    /**
     * 根据用户id获取用户信息
     * @param id    用户id
     * @return  用户实体
     */
    User selectById(Long id);
}
