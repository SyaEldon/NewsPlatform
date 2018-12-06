package org.xd.newsplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.xd.newsplatform.mapper.UserMapper;
import org.xd.newsplatform.pojo.user;

import java.util.List;


@Service
public class userService {
    @Autowired
    UserMapper userMapper;

    public List<user> getUserList(){
        List<user> userList=userMapper.getUserList();
        return userList;
    }

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

    public String getUserRightName(int userRight){
        switch(userRight){
            case 0:return "游客";
            case 1:return "注册用户";
            case 2:return "新闻发布员";
            case 3:return "管理员";
        }
        return "Unkown";
    }

    public void deleteUser(int userId){
        userMapper.deleteUser(userId);
    }

    public void updateUserRight(int userRight,int userId){
        userMapper.updateUserRight(userRight,userId);
    }
}
