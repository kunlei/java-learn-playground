package com.playground.java.jdbc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author klian
 */
@Data
@AllArgsConstructor
public class Account {
  private String name;
  private double money;
}
