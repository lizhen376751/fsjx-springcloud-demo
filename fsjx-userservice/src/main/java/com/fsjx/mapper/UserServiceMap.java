package com.fsjx.mapper;

import com.fsjx.user.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * 用户实体类与数据库的映射
 * Created by lizhen on 2018\6\1 0001.
 */
@Mapper
public interface UserServiceMap {
    /**
     * 根据id查询用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Select("select id,username,password,phone,email from UserEntity where id =#{id}")
    UserEntity findByID(@Param("id") Integer id);
}
