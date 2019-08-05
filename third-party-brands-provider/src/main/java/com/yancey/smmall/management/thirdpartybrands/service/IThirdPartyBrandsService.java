package com.yancey.smmall.management.thirdpartybrands.service;

import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsListableVO;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsQueryParam;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import org.springframework.data.domain.Page;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 16:07
 */
public interface IThirdPartyBrandsService {

    void save(ThirdPartyBrandsVO thirdPartyBrandsVO);

    /**
     * @Description:
     * @param queryParam
     * @Author: Yb.Z
     * @create: 2019/07/29 16:36
     * @return: org.springframework.data.domain.Page<com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO>
     */
    Page<ThirdPartyBrandsListableVO> listByPage(ThirdPartyBrandsQueryParam queryParam);
}
