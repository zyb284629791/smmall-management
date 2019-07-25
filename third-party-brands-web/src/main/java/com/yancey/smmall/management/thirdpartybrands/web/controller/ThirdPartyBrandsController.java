package com.yancey.smmall.management.thirdpartybrands.web.controller;

import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import com.yancey.smmall.management.common.thirdpartybrands.facade.IThirdPartyBrandFacade;
import com.yancey.smmall.management.thirdpartybrands.web.config.NormalConfig;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 15:51
 */
@RestController
@RequestMapping(NormalConfig.apiPrefix)
public class ThirdPartyBrandsController {

    @Reference
    IThirdPartyBrandFacade thirdPartyBrandFacade;

    @PostMapping
    public void save(@RequestBody @Validated ThirdPartyBrandsVO thirdPartyBrandsVO){
        thirdPartyBrandFacade.save(thirdPartyBrandsVO);
    }
}
