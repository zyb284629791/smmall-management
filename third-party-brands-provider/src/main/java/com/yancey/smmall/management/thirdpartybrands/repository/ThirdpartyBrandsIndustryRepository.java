package com.yancey.smmall.management.thirdpartybrands.repository;

import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrandsIndustry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/26 - 11:31
 */
public interface ThirdpartyBrandsIndustryRepository extends CrudRepository<ThirdPartyBrandsIndustry,Long> {

    @Query("select brandIndustryCode from ThirdPartyBrandsIndustry where brandId = ?1 and deleteFlag = 1")
    List<Integer> findBrandIndustryCodeByBrandId(Long brandId);
}
