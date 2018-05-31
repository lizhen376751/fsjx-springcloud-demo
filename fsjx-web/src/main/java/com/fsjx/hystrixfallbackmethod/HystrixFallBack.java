package com.fsjx.hystrixfallbackmethod;

import com.fsjx.base.BaseApiService;
import com.fsjx.base.ResponseBase;
import com.fsjx.fegin.UserServiceFeign;
import com.fsjx.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 断路器本地方法，如果调用其他服务，同样可以写在此类
 * Created by lizhen on 2018\5\30 0030.
 */
@Component
public class HystrixFallBack implements UserServiceFeign {
    @Autowired
    private BaseApiService baseApiService;
    @Override
    public ResponseBase getUserEntity(UserEntity userEntity) {
        return baseApiService.setErrorResponseBase("服务暂时不可用");
    }
}
