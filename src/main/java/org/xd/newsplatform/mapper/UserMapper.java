package org.xd.newsplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xd.newsplatform.pojo.user;

@Mapper
@Repository
public interface UserMapper {
    user getUserByAccount(String account);
}
