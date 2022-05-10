package com.playground.java.mybatis.mapper;

import com.playground.java.mybatis.pojo.Brand;

import java.util.List;

public interface BrandMapper {
  List<Brand> selectAll();

  Brand selectById(int id);
}
