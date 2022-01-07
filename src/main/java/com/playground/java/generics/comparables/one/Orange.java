package com.playground.java.generics.comparables.one;

public class Orange extends Fruit implements Comparable<Orange> {
  public Orange(int size) {
    super("Orange", size);
  }

  @Override
  public int compareTo(Orange o) {
    return super.compareTo(o);
  }
}
