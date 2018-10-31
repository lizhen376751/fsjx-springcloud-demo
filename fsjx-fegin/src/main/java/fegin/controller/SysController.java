package fegin.controller;//package com.framework.fegin.controller;


import fegin.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;



/**
 * Created by SYJ on 2017/4/25.
 */
@RestController
@RequestMapping(value = "/fegin")
public class SysController  {

    @Autowired
    private SysService sysService;

    /**
     * 获取用户信息
     * @param name
     * @param password
     * @return
     */
    @PostMapping(value = "/getUser")
    public String sendInterview(@RequestParam("name") String name,@RequestParam("password") String password) {
        return sysService.getUser(name,password);
    }
}
