package com.xrom.server.mapper;

import com.xrom.server.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  用户角色mapper操作
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
public interface RoleMapper {

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    /**
     * 根据用户id查询用户拥有的角色
     * @param userId    用户id
     * @return  角色列表
     */
    List<Role> selectByUserId(@Param("userId") Long userId);

}