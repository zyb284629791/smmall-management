package com.yancey.smmall.management.thirdpartybrands.web.controller;

import com.yancey.smmall.management.common.response.Response;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsQueryParam;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import com.yancey.smmall.management.common.thirdpartybrands.facade.IThirdPartyBrandFacade;
import com.yancey.smmall.management.thirdpartybrands.web.config.NormalConfig;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @Description: 新增商户
     * @param thirdPartyBrandsVO
     * @Author: Yb.Z
     * @create: 2019/07/29 16:30
     * @return: void
     */
    @PostMapping("/save")
    public void save(@RequestBody @Validated ThirdPartyBrandsVO thirdPartyBrandsVO){
        thirdPartyBrandFacade.save(thirdPartyBrandsVO);
    }

    /**
     * @Description: 分页查询
     * @param queryParam
     * @Author: Yb.Z
     * @create: 2019/07/29 16:34
     * @return: com.yancey.smmall.management.common.response.Response<org.springframework.data.domain.Page<com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO>>
     */
    @GetMapping("/list")
    public Response<Page<ThirdPartyBrandsVO>> list(ThirdPartyBrandsQueryParam queryParam){
//        Page<ThirdPartyBrandsVO> result = thirdPartyBrandFacade.listByPage(queryParam);
        return thirdPartyBrandFacade.listByPage(queryParam);
    }
}
