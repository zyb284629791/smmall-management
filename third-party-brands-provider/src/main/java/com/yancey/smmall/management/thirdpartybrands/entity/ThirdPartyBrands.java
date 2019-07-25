package com.yancey.smmall.management.thirdpartybrands.entity;

import com.yancey.smmall.management.common.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @Description : 第三方商户表
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 11:33
 */
@Entity
@Data
@ToString
@org.hibernate.annotations.Table(appliesTo = "third_party_brands",comment = "第三方商户表")
public class ThirdPartyBrands extends BaseEntity {

//    @Id
//    @Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
//    @TableGenerator(name = "brandsIdGen",table = "brandsIdGen",initialValue = 1000,pkColumnName = "pk_name varchar(100)")
//    @GeneratedValue(generator = "brandsIdGen")
//    private Long id;

    @Column(name = "brand_name",nullable = false,columnDefinition = "varchar(50) COMMENT '商户名称' ")
    private String brandName;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ThirdPartyBrandsIndustry> brandsIndustries;

    @Column(nullable = false,columnDefinition = "varchar(50) COMMENT '联系人'")
    private String contact;

    @Column(name = "contact_phone",nullable = false,columnDefinition = "varchar(50) COMMENT '联系人电话'")
    private String contactPhone;

    @Column(name = "contact_email",columnDefinition = "varchar(200) COMMENT '联系邮箱'")
    private String contactEmail;

    @Column(name = "brand_username",nullable = false,columnDefinition = "varchar(50) COMMENT '商户账号'")
    private String brandUsername;

    @Column(name = "brand_password",nullable = false,columnDefinition = "varchar(50) COMMENT '账户密码'")
    private String brandPassword;

    @Column(name = "expire_date",nullable = false,columnDefinition = "DATETIME COMMENT '有效期'")
    private Date expireDate;
}
