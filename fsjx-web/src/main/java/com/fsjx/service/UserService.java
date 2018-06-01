package com.fsjx.service;

import com.fsjx.base.LogAspectServiceApi;
import com.fsjx.base.ResponseBase;
import com.fsjx.constants.Constants;
import com.fsjx.fegin.UserServiceFeign;
import com.fsjx.user.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2018\6\1 0001.
 */
@Service
public class UserService  {
    private static final Logger log = LoggerFactory.getLogger(LogAspectServiceApi.class);

    @Autowired
    private UserServiceFeign userServiceFeign;

    public String getUserEntity(Integer id, String username, HttpServletRequest httpServletRequest) {
        log.info("web模块查询客户信息**********************************");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId(id);
        userEntity1.setUsername(username);
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
