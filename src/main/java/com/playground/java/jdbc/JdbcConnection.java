package com.playground.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {
  public static void main(String[] args) throws Exception {
    // register driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // get connection
    String url = "jdbc:mysql://127.0.0.1:3306/db1";
    String userid = "root";
    String password = "password";
    Connection connection = DriverManager.getConnection(url, userid, password);

    // define sql
    String sql1 = "UPDATE account SET money = 2000 WHERE name = 'John'";
    String sql2 = "UPDATE account SET money = 2000 WHERE name = 'Tim'";

    // acquire statement
    Statement statement = connection.createStatement();

    try {
      // begin transaction
      connection.setAutoCommit(false);

      // execute sql
      int count1 = statement.executeUpdate(sql1);

      // process result
      System.out.println(count1);

      // execute sql
      int count2 = statement.executeUpdate(sql2);

      // process result
      System.out.println(count2);

      // submit transaction
      connection.commit();
    } catch (Exception e) {
      // rollback
      connection.rollback();

      e.printStackTrace();
    }

    // release resource
    statement.close();
    connection.close();


  }
}
