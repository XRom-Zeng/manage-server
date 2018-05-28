package com.xrom.server.mapper;

import com.xrom.server.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资源权限mapper操作
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
public interface PermissionMapper {

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    List<Permission> selectByRoleId(@Param("roleId") Long roleId);

    List<Permission> selectByParentId(@Param("parentId") Long parentId);

}