package com.yancey.smmall.management.thirdpartybrands.service.impl;

import com.google.common.collect.Lists;
import com.yancey.smmall.management.common.entity.BaseEntity;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrands;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrandsIndustry;
import com.yancey.smmall.management.thirdpartybrands.repository.ThirdPartyBrandsRepository;
import com.yancey.smmall.management.thirdpartybrands.service.IThirdPartyBrandsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 16:07
 */
@Slf4j
@Service
@Transactional
public class ThirdPartyBrandsServiceImpl implements IThirdPartyBrandsService {

    @Autowired
    private ThirdPartyBrandsRepository thirdPartyBrandsRepository;

    @Override
    public void save(ThirdPartyBrandsVO thirdPartyBrandsVO) {
        log.info("==============");
        ThirdPartyBrands thirdPartyBrands = new ThirdPartyBrands();
        BeanUtils.copyProperties(thirdPartyBrandsVO,thirdPartyBrands);
        thirdPartyBrands.setCreateUser("xxx");
        List<ThirdPartyBrandsIndustry> industries = thirdPartyBrandsVO.getBrandsIndustryCodes().stream().map(code -> {
            ThirdPartyBrandsIndustry industry = new ThirdPartyBrandsIndustry();
            industry.setCreateUser(thirdPartyBrands.getCreateUser());
            industry.setBrandiIndustryCode(code);
            return industry;
        }).collect(Collectors.toList());
        thirdPartyBrands.setBrandsIndustries(industries);
        log.info("entity = {}" , thirdPartyBrands);
        thirdPartyBrandsRepository.save(thirdPartyBrands);
    }
}
