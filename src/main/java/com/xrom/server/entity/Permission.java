package com.xrom.server.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * 实体：资源权限
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
@Data
public class Permission {

    /** 主键ID */
    private Long id;

    /** 创建时间 */
    private Date createdTime;

    /** 权限名称 */
    private String name;

    /** 资源类型：0-按钮； 1-菜单 */
    private Integer resourceType;

    /** url路径 */
    private String url;

    /** 权限字符串 */
    private String permission;

    /** 父类ID */
    private Long parentId;

    /** 是否可用：0-不可用； 1-可用 */
    private Integer available;

    /** 子列表*/
    Set<Permission> permissionList;
}