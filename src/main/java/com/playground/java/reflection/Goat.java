package com.playground.java.reflection;

public class Goat extends Animal implements Locomotion {
  public Goat(String name) {
    super(name);
  }

  @Override
  protected String getSound() {
    return "bleat";
  }

  @Override
  public String eats() {
    return "grass";
  }

  @Override
  public String getLocomotion() {
    return "walks";
  }

  public static void main(String[] args) throws ClassNotFoundException {
    Object goat = new Goat("goat");
    Class<?> c = goat.getClass();
    System.out.println(c.getSimpleName());
    System.out.println(c.getName());
    System.out.println(c.getCanonicalName());

    System.out.println();
    Class<?> goatClass = Class.forName("com.playground.java.reflection.Goat");
    System.out.println(goatClass.getName());
    System.out.println(goatClass.getSimpleName());
  }
}
