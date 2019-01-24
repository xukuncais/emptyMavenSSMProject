package com.xukc.mapper;

import java.util.List;

import com.xukc.entity.User;

public interface UserMapper {
	User selectUserById(Long userId);
    List<User> selectUserList();
}