package com.yancey.smmall.management.common.thirdpartybrands.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 15:56
 */
@ApiModel
@Data
public class ThirdPartyBrandsDetailVO extends ThirdPartyBrandsVO {

    @ApiModelProperty(name = "id", value = "厂商Id", dataType = "Long")
    private Long id;

    @ApiModelProperty(name = "expire_status",value = "帐号状态",dataType = "Integer",example = "1",allowEmptyValue = true)
    private Integer expireStatus;

}
