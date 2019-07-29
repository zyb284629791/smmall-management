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
 * @Date : 2019/07/25 - 15:56
 */
@ApiModel
@Data
public class ThirdPartyBrandsVO implements Serializable {

    @ApiModelProperty(name = "id", value = "厂商Id", dataType = "Long")
    private Long id;

    @ApiModelProperty(name = "brandName", value = "商户名称", dataType = "String", example = "xxx")
    @NotNull
    private String brandName;

    @ApiModelProperty(name = "brandsIndustryCodes", value = "所属行业", dataType = "java.lang.List", example = "0,1,2,3")
    @NotNull
    private List<Integer> brandsIndustryCodes;

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

    @ApiModelProperty(name = "brandPassword", value = "账户密码", dataType = "String", example = "123")
    @NotNull
    private String brandPassword;

    @ApiModelProperty(name = "reBrandPassword", value = "确认密码", dataType = "String", example = "123")
    @NotNull
    private String reBrandPassword;

    @ApiModelProperty(name = "expireDate", value = "有效期", dataType = "Date", example = "2020-01-01")
    private Date expireDate;

    @ApiModelProperty(name = "expireFlag",value = "帐号状态",dataType = "Integer",example = "1")
    private Integer expireFlag;

}
