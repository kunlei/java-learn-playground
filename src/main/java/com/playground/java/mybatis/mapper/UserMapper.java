package com.playground.java.mybatis.mapper;

import com.playground.java.mybatis.User;

import java.util.List;

public interface UserMapper {
  List<User> selectAll();
}
