package com.yancey.smmall.management.common.thirdpartybrands.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/08/02 - 9:36
 */
@ApiModel
@Data
public class ThirdPartyBrandsListableVO implements Serializable {

    @ApiModelProperty(name = "id", value = "厂商Id", dataType = "Long")
    private Long id;

    @ApiModelProperty(name = "brandName", value = "商户名称", dataType = "String", example = "xxx")
    @NotNull
    private String brandName;

    @ApiModelProperty(name = "brandsIndustryCodes", value = "所属行业", dataType = "java.lang.List", example = "0,1,2,3")
    @NotNull
    private Integer brandsIndustryCodes;

    @ApiModelProperty(name = "contact", value = "联系人", dataType = "String", example = "xxx")
    @NotNull
    private String contact;

    @ApiModelProperty(name = "contactPhone", value = "联系电话", dataType = "String", example = "17282912819")
    @NotNull
    private String contactPhone;

    @ApiModelProperty(name = "contactEmail", value = "联系邮箱", dataType = "String", example = "xxx@qq.com")
    @Email
    private String contactEmail;

    @ApiModelProperty(name = "brandUsername", value = "商户账号", dataType = "String", example = "xxxxxx")
    @NotNull
    private String brandUsername;

    @ApiModelProperty(name = "expireDate", value = "有效期", dataType = "Date", example = "2020-01-01")
    private Date expireDate;

    @ApiModelProperty(name = "expire_status",value = "帐号状态",dataType = "Integer",example = "1",allowEmptyValue = true)
    private Integer expireStatus;


    public ThirdPartyBrandsListableVO() {
    }

    public ThirdPartyBrandsListableVO(Long id, @NotNull String brandName, @NotNull Integer brandsIndustryCodes, @NotNull String contact, @NotNull String contactPhone, @Email String contactEmail, @NotNull String brandUsername, Date expireDate, Integer expireStatus) {
        this.id = id;
        this.brandName = brandName;
        this.brandsIndustryCodes = brandsIndustryCodes;
        this.contact = contact;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.brandUsername = brandUsername;
        this.expireDate = expireDate;
        this.expireStatus = expireStatus;
    }
}
