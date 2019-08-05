package com.yancey.smmall.management.thirdpartybrands.service.impl;

import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsListableVO;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsQueryParam;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrands;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrandsIndustry;
import com.yancey.smmall.management.thirdpartybrands.repository.ThirdPartyBrandsRepository;
import com.yancey.smmall.management.thirdpartybrands.repository.ThirdpartyBrandsIndustryRepository;
import com.yancey.smmall.management.thirdpartybrands.service.IThirdPartyBrandsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private ThirdpartyBrandsIndustryRepository industryRepository;

    @Override
    public void save(ThirdPartyBrandsVO thirdPartyBrandsVO) {
        log.info("==============");
        ThirdPartyBrands thirdPartyBrands = new ThirdPartyBrands();
        BeanUtils.copyProperties(thirdPartyBrandsVO, thirdPartyBrands);
        thirdPartyBrands.setCreateUser("xxx");
        List<ThirdPartyBrandsIndustry> industries = thirdPartyBrandsVO.getBrandsIndustryCodes().stream().map(code -> {
            ThirdPartyBrandsIndustry industry = new ThirdPartyBrandsIndustry();
            industry.setCreateUser(thirdPartyBrands.getCreateUser());
            industry.setBrandIndustryCode(code);
            industry.setBrand(thirdPartyBrands);
//            industry.setBrandId(thirdPartyBrands.getId());
            return industry;
        }).collect(Collectors.toList());
        thirdPartyBrands.setBrandsIndustries(industries);
        log.info("entity = {}", thirdPartyBrands);
//        industryRepository.saveAll(industries);
        thirdPartyBrandsRepository.save(thirdPartyBrands);
    }

    @Override
    public Page<ThirdPartyBrandsListableVO> listByPage(ThirdPartyBrandsQueryParam queryParam) {
        Pageable pageable = PageRequest.of(queryParam.getPageNum(), queryParam.getPageSize());
        Page<ThirdPartyBrands> result = thirdPartyBrandsRepository.listByPage
                (queryParam, pageable);
        List<ThirdPartyBrandsListableVO> listableVOS = result.getContent().stream().map(brand ->
                convertToListableVO(brand)).collect(Collectors.toList());
        Page<ThirdPartyBrandsListableVO> listableResult = new PageImpl<>(listableVOS, pageable, result.getTotalElements());
        log.info("page result = {}", listableResult.getContent());
        return listableResult;
    }

    private ThirdPartyBrandsListableVO convertToListableVO(ThirdPartyBrands brand) {
        ThirdPartyBrandsListableVO detailVO = new ThirdPartyBrandsListableVO();
        BeanUtils.copyProperties(brand, detailVO);
        List<Integer> industryCodes = industryRepository.findBrandIndustryCodeByBrandId(brand.getId());
        detailVO.setBrandsIndustryCodes(industryCodes);
        return detailVO;
    }
}
