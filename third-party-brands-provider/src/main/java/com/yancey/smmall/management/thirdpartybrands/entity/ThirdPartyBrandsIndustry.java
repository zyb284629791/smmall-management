package com.yancey.smmall.management.thirdpartybrands.entity;

import com.yancey.smmall.management.common.entity.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * @Description : 第三方商户所属行业表
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 11:34
 */
@Table(appliesTo = "third_party_brands_industry", comment = "第三方商户所属行业表")
@Data
@Deprecated
@DynamicInsert
@DynamicUpdate
@Entity
public class ThirdPartyBrandsIndustry extends BaseEntity {


    @Column(name = "brand_industry_code", nullable = false, columnDefinition =
            "tinyint(2) COMMENT '所属行业 0:酒店,1:餐饮,2:旅游,3:母婴,4:娱乐,5:生活,6:运动,7:电子数码,8:其他'")
    private Integer brandIndustryCode;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false, columnDefinition = "bigint COMMENT '商户id'", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
//    @Column(name = "brand_id",nullable = false,columnDefinition = "bigint COMMENT '商户id'")
    private ThirdPartyBrands brand;

    @Override
    public String toString() {
        return "ThirdPartyBrandsIndustry{" +
                "brandIndustryCode=" + brandIndustryCode +
                ", brand=" + brand.getId() +
                '}';
    }
}
