package com.playground.java.jdbc.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
  public static void main(String[] args) throws Exception {
    System.out.println(System.getProperty("user.dir"));

    // load configuration file
    Properties prop = new Properties();
    prop.load(new FileInputStream("src/main/resources/druid.properties"));

    // acquire connection object
    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

    Connection conn = dataSource.getConnection();

    System.out.println(conn);
  }
}
