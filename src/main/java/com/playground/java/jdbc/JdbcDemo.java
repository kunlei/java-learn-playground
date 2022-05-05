package com.playground.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo {
  public static void main(String[] args) throws Exception {
    // register driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // get connection
    String url = "jdbc:mysql://127.0.0.1:3306/db1";
    String userid = "root";
    String password = "password";
    Connection connection = DriverManager.getConnection(url, userid, password);

    // define sql
    String sql = "UPDATE account SET money = 2000 WHERE name = 'John'";

    // acquire statement
    Statement statement = connection.createStatement();

    // execute sql
    int count = statement.executeUpdate(sql);

    // process result
    System.out.println(count);

    // release resource
    statement.close();
    connection.close();
  }
}
