package com.playground.java.mybatis.mapper;

import com.playground.java.mybatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
  List<Brand> selectAll();

  Brand selectById(int id);

  List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName,
                                @Param("brandName") String brandName);

  List<Brand> selectByConditionObject(Brand brand);

  List<Brand> selectByConditionMap(Map<String, String> map);
}
