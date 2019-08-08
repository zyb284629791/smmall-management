package com.yancey.smmall.management.thirdpartybrands.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 第三方商户所属行业表
 * </p>
 *
 * @author Yb.Z
 * @since 2019-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ThirdPartyBrandsIndustry implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键，自动生成
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 删除标识，0：删除，1：未删除
     */
    private Integer delFlag;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 最后修改人
     */
    private String updateUser;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 所属行业 0:酒店,1:餐饮,2:旅游,3:母婴,4:娱乐,5:生活,6:运动,7:电子数码,8:其他
     */
    private Integer brandIndustryCode;

    /**
     * 商户id
     */
    private Long brandId;


}
