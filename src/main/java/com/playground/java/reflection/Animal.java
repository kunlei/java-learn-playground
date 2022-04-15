package com.playground.java.reflection;

import lombok.Data;

@Data
public abstract class Animal implements Eating {
  public static String CATEGORY = "domestic";
  private String name;

  public Animal(String name) {
    this.name = name;
  }

  protected abstract String getSound();
}
