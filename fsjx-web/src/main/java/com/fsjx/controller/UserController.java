package com.fsjx.controller;

import com.fsjx.base.ResponseBase;
import com.fsjx.constants.Constants;
import com.fsjx.fegin.UserServiceFeign;
import com.fsjx.user.entity.UserEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * 用户控制层
 * Created by lizhen on 2018\5\29 0029.
 */
@Controller
//表示标识这个类是swagger的资源,tags–表示说明,value–也是说明，可以使用tags替代
@Api(value = "用户controller", tags = {"用户操作接口"})
public class UserController {
    @Autowired
    private UserServiceFeign userServiceFeign;

    //@ApiOperation()用于方法；表示一个http请求的操作,value用于方法描述,notes用于提示内容,tags可以重新分组（视情况而用）
    @ApiOperation(value = "获取用户信息")
    //ApiResponse：响应集配置;
    @ApiResponses({@ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 404, message = "权限不足")})
    //用在方法上包含一组参数说明,paramType–参数类型;name–参数名称;value–参数说明;dataType–数据类型(有String/int);required ： 是否必要;defaultValue：参数的默认值
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "id", value = "用户id", dataType = "int", required = true),
            @ApiImplicitParam(paramType = "query", name = "username", value = "用户姓名", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "token", value = "令牌（测试）", dataType = "String", required = true)})
    @GetMapping("/getUserEntity")
    public String getUserEntity(Integer id, String username, HttpServletRequest httpServletRequest) {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId(id);
        userEntity1.setUsername(username);
        userEntity1.setPassword("md5");
        userEntity1.setPhone("18560042032");
        ResponseBase userEntity = userServiceFeign.getUserEntity(userEntity1);
        if (userEntity.getRtncode().equals(Constants.HTTP_RES_CODE_200)) {
            LinkedHashMap map = (LinkedHashMap) userEntity.getRtndata();
            httpServletRequest.setAttribute("username", map.get("username"));
        }
        if (userEntity.getRtncode().equals(Constants.HTTP_RES_CODE_500)) {
            String rtnmsg = userEntity.getRtnmsg();
            httpServletRequest.setAttribute("username", rtnmsg);
        }
        return "index";
    }

}
