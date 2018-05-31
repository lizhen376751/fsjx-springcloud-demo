package com.fsjx.service;


import com.fsjx.base.BaseApiService;
import com.fsjx.base.ResponseBase;
import com.fsjx.user.entity.UserEntity;
import com.fsjx.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理具体实现
 * Created by lizhen on 2018\5\29 0029.
 */
@RequestMapping("/user")
@RestController
@Api(value = "查询接口", tags = {"查询用户接口"})
public class UserServiceImp implements UserService {
    @Autowired
    private BaseApiService baseApiService;


    @ApiOperation(value = "获取用户信息接口", notes = "根据User对象创建用户")
    //用在方法上包含一组参数说明,paramType–参数类型;name–参数名称;value–参数说明;dataType–数据类型(有String/int);required ： 是否必要;defaultValue：参数的默认值
    @ApiImplicitParams({@ApiImplicitParam(name = "userEntity", value = "用户实体user", required = true, dataType = "UserEntity"),
            @ApiImplicitParam(paramType = "query", name = "token", value = "令牌（测试）", dataType = "String", required = true,defaultValue = "token")})
    @PostMapping("/getUserEntity")
    public ResponseBase getUserEntity(@RequestBody UserEntity userEntity) {
        userEntity.setId(1);
        userEntity.setUsername(userEntity.getUsername());
        userEntity.setPassword("md5");
        userEntity.setPhone("18560042032");
        return baseApiService.setSuccessResponseBase(userEntity);
    }
}
