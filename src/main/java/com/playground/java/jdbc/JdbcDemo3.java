package com.playground.java.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo3 {
  public static void main(String[] args) throws Exception {
    // register driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // get connection
    String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false&useServerPrepStmts=true";
    String userid = "root";
    String password = "password";
    Connection connection = DriverManager.getConnection(url, userid, password);

    // get username and password
    String nm = "John";
    String pwd = "pwd";

    // define sql
    String sql = "SELECT * FROM tb_user WHERE username = ? AND password = ?";

    // acquire statement
    PreparedStatement statement = connection.prepareStatement(sql);

    // set values
    statement.setString(1, nm);
    statement.setString(2, pwd);

    // execute sql
    ResultSet rs = statement.executeQuery();

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
