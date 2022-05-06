package com.playground.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo2 {
  public static void main(String[] args) throws Exception {
    // register driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // get connection
    String url = "jdbc:mysql://127.0.0.1:3306/db1";
    String userid = "root";
    String password = "password";
    Connection connection = DriverManager.getConnection(url, userid, password);

    // define sql
    String sql = "SELECT * FROM account;";

    // acquire statement
    Statement statement = connection.createStatement();

    // execute sql
    ResultSet rs = statement.executeQuery(sql);

    // process result
    List<Account> accounts = new ArrayList<>();
    while (rs.next()) {
      String name = rs.getString(1); // rs.getString("name");
      double money = rs.getDouble(2); // rs.getDouble("money");
      Account account = new Account(name, money);
      accounts.add(account);
    }
    accounts.forEach(System.out::println);

    // release resource
    rs.close();
    statement.close();
    connection.close();
  }
}
