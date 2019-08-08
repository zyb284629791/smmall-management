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
 * 第三方商户表
 * </p>
 *
 * @author Yb.Z
 * @since 2019-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ThirdPartyBrands implements Serializable {

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
     * 商户名称
     */
    private String brandName;

    /**
     * 账户密码
     */
    private String brandPassword;

    /**
     * 商户账号
     */
    private String brandUsername;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系邮箱
     */
    private String contactEmail;

    /**
     * 联系人电话
     */
    private String contactPhone;

    /**
     * 有效期
     */
    private LocalDateTime expireDate;

    /**
     * 是否过期 0:过期 1:未过期
     */
    private Integer expireStatus;


}
