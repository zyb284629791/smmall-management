package com.yancey.smmall.management.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description : 基础实体类
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 15:03
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    @Id
    @Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_user",nullable = false,columnDefinition = "varchar(50) COMMENT'创建人'" )
    private String createUser;

    @Column(name = "create_time",nullable = false,columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createTime;

    @Column(name = "update_user",columnDefinition = "varchar(50) COMMENT'最后修改人' ")
    private String updateUser;

    @Column(name = "update_time",columnDefinition = "DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间'")
    private Date updateTime;

    @Column(name = "version",columnDefinition="int DEFAULT 0 COMMENT '版本号'")
    @Version
    private Integer version;

    @Column(name = "del_flag",nullable = false,columnDefinition = "tinyint(2) DEFAULT 1 COMMENT '删除标识，0：删除，1：未删除'")
    private Boolean deleteFlag;
}
