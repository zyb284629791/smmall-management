package com.yancey.smmall.management.thirdpartybrands.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.yancey.smmall.management.common.thirdpartybrands.facade.IThirdPartyFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description :
 * @Author : Yb.Z
 * @Date : 2019/07/24 - 17:12
 */
@Service
@Component
@Slf4j
public class ThirdPartyFacade implements IThirdPartyFacade {

    @Override
    public String test() {
        return "test successful";
    }
}
