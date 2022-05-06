package com.playground.java.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.net.PortUnreachableException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {

  @Test
  public void testSelectAll() throws Exception {
    // acquire druid configurations
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/main/resources/druid.properties"));

    // create Druid connection pool
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // acquire connection
    Connection conn = dataSource.getConnection();

    // prepare statement
    String sql = "select * from tb_brand;";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    // execute query
    ResultSet rs = pstmt.executeQuery();

    // process results
    List<Brand> brands = new ArrayList<>();
    while (rs.next()) {
      Brand brand = new Brand();
      brand.setId(rs.getInt("id"));
      brand.setBrandName(rs.getString("brand_name"));
      brand.setCompanyName(rs.getString("company_name"));
      brand.setOrdered(rs.getInt("ordered"));
      brand.setDescription(rs.getString("description"));
      brand.setStatus(rs.getInt("status"));
      brands.add(brand);
    }
    brands.forEach(System.out::println);

    rs.close();
    pstmt.close();
    conn.close();
  }

  @Test
  public void testAdd() throws Exception {
    String brandName = "Rogue";
    String companyName = "Nissan";
    int ordered = 1;
    String description = "SUV";
    int status = 1;

    // load DRUID properties
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/main/resources/druid.properties"));

    // acquire connection pool
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // get connection
    Connection conn = dataSource.getConnection();

    // define sql
    String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status)" +
      "VALUES (?, ?, ?, ?, ?);";

    // get PreparedStatement object
    PreparedStatement pstmt = conn.prepareStatement(sql);

    // set parameters
    pstmt.setString(1, brandName);
    pstmt.setString(2, companyName);
    pstmt.setInt(3, ordered);
    pstmt.setString(4, description);
    pstmt.setInt(5, status);

    // execute query
    int count = pstmt.executeUpdate();

    // process result
    System.out.println(count > 0);

    // release resources
    pstmt.close();
    conn.close();
  }

  @Test
  public void testUpdate() throws Exception {
    // accept parameters
    String brandName = "Maxima";
    String companyName = "Nissan";
    int ordered = 2;
    String description = "old car";
    int status = 0;

    // load druid configurations
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/main/resources/druid.properties"));

    // create Druid connection pool
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // acquire connection
    Connection conn = dataSource.getConnection();

    // define sql statement
    String sql = "UPDATE tb_brand SET brand_name = ?," +
      "company_name = ?, ordered = ?, description = ?, status = ? where id = ?;";

    // get prepared statement object
    PreparedStatement pstmt = conn.prepareStatement(sql);

    // set parameters
    pstmt.setString(1, brandName);
    pstmt.setString(2, companyName);
    pstmt.setInt(3, ordered);
    pstmt.setString(4, description);
    pstmt.setInt(5, status);
    pstmt.setInt(6, 4);

    // execute sql
    int count = pstmt.executeUpdate();

    // process result
    System.out.println(count > 0);

    // release resources
    pstmt.close();
    conn.close();
  }

  @Test
  public void testDeleteById() throws Exception {
    //
    int id = 4;

    // load druid configurations
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/main/resources/druid.properties"));

    // create druid connection pool
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    // acquire connection
    Connection conn = dataSource.getConnection();

    // prepare statement
    String sql = "DELETE FROM tb_brand WHERE id = ?;";
    PreparedStatement pstmt = conn.prepareStatement(sql);

    // set parameters
    pstmt.setInt(1, id);

    // execute sql
    int count = pstmt.executeUpdate();

    // process result
    System.out.println(count > 0);

    // release resources
    pstmt.close();
    conn.close();
  }
}