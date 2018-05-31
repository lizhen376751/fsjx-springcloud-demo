package com.fsjx.user.service;

import com.fsjx.base.ResponseBase;
import com.fsjx.user.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理接口
 * Created by lizhen on 2018\5\29 0029.
 */
public interface UserService {
    @RequestMapping("/user/getUserEntity")
    public ResponseBase getUserEntity(@RequestBody UserEntity userEntity);
}
