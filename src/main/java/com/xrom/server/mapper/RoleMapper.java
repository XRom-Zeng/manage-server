package com.xrom.server.mapper;

import com.xrom.server.entity.Role;

/**
 *  用户角色mapper操作
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
public interface RoleMapper {

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

}