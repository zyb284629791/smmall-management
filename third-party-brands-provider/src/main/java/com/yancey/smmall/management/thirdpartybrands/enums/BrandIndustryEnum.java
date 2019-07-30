package com.yancey.smmall.management.thirdpartybrands.enums;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/25 - 16:37
 */
public enum  BrandIndustryEnum {

    HOTEL("酒店",0),
    RESTURANT("餐饮",1),
    TRAVELING("旅游",2),
    BABY("母婴",3),
    ENTERTAINMENT("娱乐",4),
    LIFE("生活",5),
    SPORTS("运动",6),
    DIGITAL("电子数码",7),
    OTHER("其他",8)
    ;

    private final Integer code;
    private final String name;

    BrandIndustryEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static BrandIndustryEnum valueOf(Integer code){
        BrandIndustryEnum result = BrandIndustryEnum.OTHER;
        if (code != null) {
            for (BrandIndustryEnum value : BrandIndustryEnum.values()) {
                if (value.code.intValue() == code.intValue()) {
                    result = value;
                }
            }
        }
        return result;

    }
}


