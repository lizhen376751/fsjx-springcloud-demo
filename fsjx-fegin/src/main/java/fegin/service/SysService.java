package fegin.service;//package com.framework.fegin.service;


import fegin.client.SysClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by SYJ on 2017/4/26.
 */
@Service
public class SysService  {

    @Autowired
    private SysClient sysClient;

    public String getUser(String name,String password) {
        return sysClient.getUser(name,password);
    }
}
