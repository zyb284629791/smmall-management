package com.yancey.smmall.management.thirdpartybrands.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yancey.smmall.management.common.thirdpartybrands.facade.IThirdPartyFacade;
import com.yancey.smmall.management.thirdpartybrands.web.config.NormalConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 16:39
 */
@RestController
@RequestMapping(NormalConfig.apiPrefix + "/hello")
@Api
public class HelloController {

    @Reference
    private IThirdPartyFacade thirdPartyFacade;

    @GetMapping
    @ApiOperation(value = "test controller")
    public String sayHello(){
        return thirdPartyFacade.test();
    }
}
