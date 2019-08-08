package com.yancey.smmall.management.thirdpartybrands.repository;

import com.google.common.collect.Lists;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsListableVO;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsQueryParam;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 16:08
 */
public interface ThirdPartyBrandsRepository extends CrudRepository<ThirdPartyBrands, Long>, JpaSpecificationExecutor {

    /**
     * @param queryParam
     * @param pageable
     * @Description: 根据过期状态和商户名称分页查找
     * @Author: Yb.Z
     * @create: 2019/07/29 16:42
     * @return: org.springframework.data.domain.Page<com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsVO>
     */
//    Page<ThirdPartyBrands> listByPage(String brandName, String brandUserName, Integer brandState, Pageable pageable);
    default Page<ThirdPartyBrands> listByPage(ThirdPartyBrandsQueryParam queryParam, Pageable pageable) {
        Specification<ThirdPartyBrands> specification = (Specification<ThirdPartyBrands>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = Lists.newArrayList();
            predicates.add(criteriaBuilder.equal(root.get("brandName").as(String.class), queryParam.getBrandName()));
            predicates.add(criteriaBuilder.equal(root.get("brandUsername").as(String.class), queryParam.getBrandName()));
            Predicate[] predicatesArray = new Predicate[predicates.size()];
            predicatesArray = predicates.toArray(predicatesArray);
            Predicate predicateOr = criteriaBuilder.or(predicatesArray);
            Predicate expireStatus = criteriaBuilder.equal(root.get("expireStatus").as(Integer.class), queryParam.getBrandState());
            return query.where(predicateOr, expireStatus).getRestriction();
        };
        return findAll(specification, pageable);
    }

    @Query("select new com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsListableVO(b.id,b.brandName,t.brandIndustryCode," +
            "b.contact,b.contactPhone,b.contactEmail,b.brandUsername,b.expireDate,b.expireStatus) from ThirdPartyBrands b left join " +
            "ThirdPartyBrandsIndustry t on b.id = t.brand.id where (b.brandName = ?1 or b.brandUsername = ?2) and b.expireStatus = ?3")
    List<ThirdPartyBrandsListableVO> listByPage2(String brandName, String brandUserName, Integer brandState);

    List<ThirdPartyBrands> findByBrandNameOrBrandUsernameAndExpireStatus(String brandName, String brandUserName, Integer brandState);
}
