package org.xd.newsplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xd.newsplatform.pojo.user;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<user> getUserList();

    user getUserByAccount(String account);

    user getUserByName(String name);

    int registerAccount(user user);

    int deleteUser(int userId);

    int updateUserRight(@Param(value = "userRight") int userRight,@Param(value = "userId") int userId);
}
