package com.yancey.smmall.management.common.thirdpartybrands.facade;

import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsListableVO;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsQueryParam;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import org.springframework.data.domain.Page;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 17:06
 */
public interface IThirdPartyBrandFacade {

    void save(ThirdPartyBrandsVO thirdPartyBrandsVO);

    /**
     * @Description: 分页查询商户
     * @param queryParam
     * @Author: Yb.Z
     * @create: 2019/07/29 16:34
     * @return: org.springframework.data.domain.Page<com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO>
     */
    Page<ThirdPartyBrandsListableVO> listByPage(ThirdPartyBrandsQueryParam queryParam);
}
