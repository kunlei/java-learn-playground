package com.playground.java.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisDemo {
  public static void main(String[] args) throws Exception {
    // load mybatis configuration
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire sql session object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // execute sql
    List<User> users = sqlSession.selectList("test.selectUser");

    users.forEach(System.out::println);

    // release resources
    sqlSession.close();
  }
}
