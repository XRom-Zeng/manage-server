package com.xrom.server.entity;

import lombok.Data;

import java.util.Date;

/**
 * 实体：角色
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
@Data
public class Role {

    /** 主键ID */
    private Long id;

    /** 创建时间 */
    private Date createdTime;

    /** 角色标识符 */
    private String role;

    /** 角色描述 */
    private String description;

    /** 是否可用： 0-不可用； 1-可用 */
    private Integer available;
}