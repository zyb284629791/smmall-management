package com.yancey.smmall.management.thirdpartybrands.entity;

import com.yancey.smmall.management.common.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * @Description : 第三方商户所属行业表
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 11:34
 */
@Table(appliesTo = "third_party_brands_industry",comment = "第三方商户所属行业表")
@Data
@Entity
public class ThirdPartyBrandsIndustry extends BaseEntity {

    @Column(name = "brand_industry_code",nullable = false,columnDefinition = "tinyint(2) COMMENT '所属行业'")
    private Integer brandiIndustryCode ;

    @ManyToOne
    @JoinColumn(name = "brand_id")
//    @Column(name = "brand_id",nullable = false,columnDefinition = "bigint COMMENT '商户id'")
    private ThirdPartyBrands brand ;

}
