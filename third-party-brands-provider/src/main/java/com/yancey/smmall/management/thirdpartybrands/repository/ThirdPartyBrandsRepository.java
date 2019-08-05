package com.yancey.smmall.management.thirdpartybrands.repository;

import com.google.common.collect.Lists;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsListableVO;
import com.yancey.smmall.management.common.thirdpartybrands.entity.ThirdPartyBrandsQueryParam;
import com.yancey.smmall.management.thirdpartybrands.entity.ThirdPartyBrands;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

//    default Page<ThirdPartyBrandsListableVO> listByPage2(ThirdPartyBrandsQueryParam queryParam, Pageable pageable) {
//        Specification<ThirdPartyBrandsListableVO> specification = (Specification<ThirdPartyBrandsListableVO>) (root, query, criteriaBuilder) -> {
//            List<Predicate> predicates = Lists.newArrayList();
//            predicates.add(criteriaBuilder.equal(root.get("brandName").as(String.class), queryParam.getBrandName()));
//            predicates.add(criteriaBuilder.equal(root.get("brandUsername").as(String.class), queryParam.getBrandName()));
//            Predicate[] predicatesArray = new Predicate[predicates.size()];
//            predicatesArray = predicates.toArray(predicatesArray);
//            Predicate predicateOr = criteriaBuilder.or(predicatesArray);
//            Predicate expireStatus = criteriaBuilder.equal(root.get("expireStatus").as(Integer.class), queryParam.getBrandState());
//            root.join()
//        };
//    }
}
