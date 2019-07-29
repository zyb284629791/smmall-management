package com.yancey.smmall.management.common.thirdpartybrands.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/29 - 16:04
 */
@ApiModel("第三方商户管理查询参数")
@Data
public class ThirdPartyBrandsQueryParam implements Serializable {

    @ApiModelProperty(name = "brandName",value = "商户名称/账号",dataType = "String",example = "xxx")
    private String brandName;

    @ApiModelProperty(name = "brandState",value = "商户状态",dataType = "Integer",example = "1")
    private Integer brandState;

    @ApiModelProperty(name = "pageSize" ,value = "分页大小",dataType = "Integer",example = "10")
    private Integer pageSize;

    @ApiModelProperty(name = "pageNum" ,value = "当前页",dataType = "Integer",example = "1")
    private Integer pageNum;
}
