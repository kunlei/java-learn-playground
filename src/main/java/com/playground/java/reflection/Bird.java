package com.playground.java.reflection;

import java.lang.reflect.Constructor;

public class Bird extends Animal {
  private boolean walks;

  public Bird() {
    super("bird");
  }

  public Bird(String name) {
    super(name);
  }

  public Bird(String name, boolean walks) {
    super(name);
    setWalks(walks);
  }

  public void setWalks(boolean walks) {
    this.walks = walks;
  }

  @Override
  protected String getSound() {
    return null;
  }

  @Override
  public String eats() {
    return null;
  }

  public boolean walks() {
    return walks;
  }

  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> c = Class.forName("com.playground.java.reflection.Bird");
    Constructor<?>[] cons1 = c.getConstructors();
  }
}
