package com.xrom.server.mapper;

import com.xrom.server.entity.User;

/**
 * 用户mapper操作
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
public interface UserMapper {

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    /**
     * 根据用户电话号码查询用户
     * @param phone 电话号码
     * @return
     */
    User selectByPhone(String phone);
}