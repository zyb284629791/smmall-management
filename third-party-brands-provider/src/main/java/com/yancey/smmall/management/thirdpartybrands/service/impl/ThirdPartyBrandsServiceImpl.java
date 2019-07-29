package com.yancey.smmall.management.thirdpartybrands.service.impl;

import com.yancey.smmall.management.common.response.Response;
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
        BeanUtils.copyProperties(thirdPartyBrandsVO,thirdPartyBrands);
        thirdPartyBrands.setCreateUser("xxx");
        log.info("entity = {}" , thirdPartyBrands);
        thirdPartyBrandsRepository.save(thirdPartyBrands);
        List<ThirdPartyBrandsIndustry> industries = thirdPartyBrandsVO.getBrandsIndustryCodes().stream().map(code -> {
            ThirdPartyBrandsIndustry industry = new ThirdPartyBrandsIndustry();
            industry.setCreateUser(thirdPartyBrands.getCreateUser());
            industry.setBrandiIndustryCode(code);
            industry.setBrandId(thirdPartyBrands.getId());
            return industry;
        }).collect(Collectors.toList());
        industryRepository.saveAll(industries);
    }

    @Override
    public Response<Page<ThirdPartyBrandsVO>> listByPage(ThirdPartyBrandsQueryParam queryParam) {
        Pageable pageable = PageRequest.of(queryParam.getPageNum(), queryParam.getPageSize());
        Page<ThirdPartyBrandsVO> result = thirdPartyBrandsRepository.findByExpireFlagAndBrandNameOrBrandUsername
                (queryParam.getBrandState(),queryParam.getBrandName(),queryParam.getBrandName(),pageable);
        result.forEach(vo -> {
            vo.setBrandPassword(null);
            vo.setReBrandPassword(null);
//            vo.getBrandsIndustryCodes()
        });
        return Response.instance().data(result);
    }
}
