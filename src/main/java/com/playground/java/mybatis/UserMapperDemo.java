package com.playground.java.mybatis;

import com.playground.java.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperDemo {
  public static void main(String[] args) throws IOException {
    // 1. load mybatis configuration file
    String resources = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resources);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // 2. get sqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // execute sql
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> users = userMapper.selectAll();

    users.forEach(System.out::println);

    // release resources
    sqlSession.close();
  }
}
