package com.xrom.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: XRom
 * @Date: 2018-01-27 13:33:14
 * 实体类：用户
 */
@Data
public class User implements Serializable {

    private Long id;

    private String username;

    private Date createDate = new Date();

    private Long departmentId;

}
