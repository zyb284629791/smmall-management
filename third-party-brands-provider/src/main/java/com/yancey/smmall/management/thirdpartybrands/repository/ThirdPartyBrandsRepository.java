package com.yancey.smmall.management.thirdpartybrands.repository;

import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 16:08
 */
public interface ThirdPartyBrandsRepository extends CrudRepository<ThirdPartyBrands,Long> {

    /**
     * @Description: 根据过期状态和商户名称分页查找
     * @param brandState
     * @param brandName
     * @param brandName1
     * @param pageable
     * @Author: Yb.Z
     * @create: 2019/07/29 16:42
     * @return: org.springframework.data.domain.Page<com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO>
     */
    Page<ThirdPartyBrandsVO> findByExpireFlagAndBrandNameOrBrandUsername(Integer brandState, String brandName, String brandName1, Pageable pageable);
}
