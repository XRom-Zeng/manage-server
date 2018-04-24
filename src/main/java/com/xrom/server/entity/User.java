package com.xrom.server.entity;

import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * 实体：用户信息
 * @author: XRom
 * @date: 2018-04-17 17:57:02
 */
@Data
public class User {

    /** 用户ID */
    private Long id;

    /** 创建时间 */
    private Date createdTime;

    /** 最后登录时间 */
    private Date lastLoginTime;

    /** 用户姓名 */
    private String username;

    /** 用户电话 */
    private String phone;

    /** 登录密码 */
    private String password;

    /** 性别：0-女； 1-男*/
    private Integer sex;

    /** 状态：0-冻结； 1-正常*/
    private Integer state;

    /** 用户角色 */
    private Set<Role> roles;
}