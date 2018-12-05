package org.xd.newsplatform.service;


import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.xd.newsplatform.mapper.UserMapper;

@Service
public class say {
    @Autowired
    UserMapper userMapper;


    public void say(){
        System.out.println(userMapper.getUserByAccount("2016024255"));
    }
}
