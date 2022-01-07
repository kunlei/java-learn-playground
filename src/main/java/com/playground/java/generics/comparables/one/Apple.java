package com.playground.java.generics.comparables.one;

public class Apple extends Fruit implements Comparable<Apple> {
  public Apple(int size) {
    super("Apple", size);
  }

  @Override
  public int compareTo(Apple o) {
    return super.compareTo(o);
  }
}
