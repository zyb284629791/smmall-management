package com.yancey.smmall.management.thirdpartybrands.entity;

import com.yancey.smmall.management.common.entity.BaseEntity;
import com.yancey.smmall.management.thirdpartybrands.consts.DeleteFlagConst;
import com.yancey.smmall.management.thirdpartybrands.consts.TableNameConst;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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
@Deprecated
@DynamicInsert
@DynamicUpdate
@SQLDelete(sql = "update " + TableNameConst.THIRD_PARTY_BRANDS + " t set t.del_flag = " + DeleteFlagConst.DELETED + " where t.id = ?")
@Where(clause = " del_flag = " + DeleteFlagConst.UN_DELETED)
@org.hibernate.annotations.Table(appliesTo = TableNameConst.THIRD_PARTY_BRANDS, comment = "第三方商户表")
public class ThirdPartyBrands extends BaseEntity {

    @Column(name = "brand_name", nullable = false, columnDefinition = "varchar(50) COMMENT '商户名称' ")
    private String brandName;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @org.hibernate.annotations.ForeignKey(name = "none")
    private List<ThirdPartyBrandsIndustry> brandsIndustries;

    @Column(nullable = false, columnDefinition = "varchar(50) COMMENT '联系人'")
    private String contact;

    @Column(name = "contact_phone", nullable = false, columnDefinition = "varchar(50) COMMENT '联系人电话'")
    private String contactPhone;

    @Column(name = "contact_email", columnDefinition = "varchar(200) COMMENT '联系邮箱'")
    private String contactEmail;

    @Column(name = "brand_username", nullable = false, columnDefinition = "varchar(50) COMMENT '商户账号'")
    private String brandUsername;

    @Column(name = "brand_password", nullable = false, columnDefinition = "varchar(50) COMMENT '账户密码'")
    private String brandPassword;

    @Column(name = "expire_date", nullable = false, columnDefinition = "DATETIME COMMENT '有效期'")
    private Date expireDate;

    @Column(name = "expire_status", columnDefinition = "tinyint(2) DEFAULT 1 COMMENT '是否过期 0:过期 1:未过期'")
    private Integer expireStatus;

    @Override
    public String toString() {
        return "ThirdPartyBrands{" +
                "brandName='" + brandName + '\'' +
                ", brandsIndustries=" + brandsIndustries +
                ", contact='" + contact + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", brandUsername='" + brandUsername + '\'' +
                ", brandPassword='" + brandPassword + '\'' +
                ", expireDate=" + expireDate +
                ", expireStatus=" + expireStatus +
                '}';
    }
}
