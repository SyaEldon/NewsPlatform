package org.xd.newsplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.xd.newsplatform.mapper.UserMapper;
import org.xd.newsplatform.pojo.user;


@Service
public class userService {
    @Autowired
    UserMapper userMapper;

    public int registerAccount(user user) {
        user userAccountCheck = userMapper.getUserByAccount(user.getAccount());
        user userNameCheck = userMapper.getUserByName(user.getName());
        if (userAccountCheck == null && userNameCheck == null){
            userMapper.registerAccount(user);
            return 1;
        }
        else if(userAccountCheck!=null){
            return 2;
        }
        else
            return 3;

    }

    public int login(user user){
        user userExample=userMapper.getUserByAccount(user.getAccount());
        if(userExample==null){
            return 0;
        }
        else if(userExample.getPassword().equals(user.getPassword())){
            return 1;
        }
        return 2;
    }

    public user getUser(String account){
        user user=userMapper.getUserByAccount(account);
        return user;
    }
}
