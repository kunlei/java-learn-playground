package com.playground.java.mybatis.mapper;

import com.playground.java.mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

  @Test
  public void testSelectAll() throws Exception {
    // acquire SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute sql
    List<Brand> brands = brandMapper.selectAll();
    brands.forEach(System.out::println);

    sqlSession.close();
  }

  @Test
  public void testSelectById() throws Exception {
    // acquire SqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    // acquire SqlSession object
    SqlSession sqlSession = sqlSessionFactory.openSession();

    // acquire mapper
    BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

    // execute query
    Brand brand = brandMapper.selectById(1);
    System.out.println(brand.toString());

    sqlSession.close();


  }

}