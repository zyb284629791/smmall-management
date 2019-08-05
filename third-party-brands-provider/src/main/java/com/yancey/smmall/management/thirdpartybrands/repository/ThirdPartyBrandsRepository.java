package com.yancey.smmall.management.thirdpartybrands.repository;

import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 16:08
 */
public interface ThirdPartyBrandsRepository extends CrudRepository<ThirdPartyBrands,Long> {

    /**
     * @Description: 根据过期状态和商户名称分页查找
     * @param brandName
     * @param brandUserName
     * @param brandState
     * @param pageable
     * @Author: Yb.Z
     * @create: 2019/07/29 16:42
     * @return: org.springframework.data.domain.Page<com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO>
     */
    Page<ThirdPartyBrands> findByBrandNameOrBrandUsernameAndExpireStatus(String brandName, String brandUserName, Integer brandState, Pageable pageable);

    List<ThirdPartyBrands> findAllByBrandNameOrBrandUsernameAndExpireStatus(String brandName, String brandUserName, Integer brandState);
}
