package org.xd.newsplatform.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xd.newsplatform.mapper.UserMapper;
import org.xd.newsplatform.pojo.user;


@RunWith(SpringRunner.class)
@SpringBootTest
public class sayTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void say(){
        user a=userMapper.getUserByAccount("2016024255");
        System.out.println(a.getName());
    }
}