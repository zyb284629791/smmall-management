package com.yancey.smmall.management.thirdpartybrands.facade;

import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import com.yancey.smmall.management.common.thirdpartybrands.facade.IThirdPartyBrandFacade;
import com.yancey.smmall.management.thirdpartybrands.service.IThirdPartyBrandsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 17:12
 */
@Service
@Slf4j
public class ThirdPartyBrandsFacade implements IThirdPartyBrandFacade {

    @Autowired
    private IThirdPartyBrandsService thirdPartyBrandsService;

    @Override
    public void save(ThirdPartyBrandsVO thirdPartyBrandsVO) {
        Assert.notNull(thirdPartyBrandsVO,"参数不能为空");
        log.info("{} save third party brands method",ThirdPartyBrandsFacade.class.getName());
        thirdPartyBrandsService.save(thirdPartyBrandsVO);
    }
}
