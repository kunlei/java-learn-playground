package com.playground.java.generics;

import java.util.Comparator;

public class Box implements Comparable<Box> {
  private final int length;

  private Comparator<Box> comparator;

  public Box(int length, Comparator<Box> comparator) {
    this.length = length;
    this.comparator = comparator;
  }

  @Override
  public int compareTo(Box o) {
    return Integer.compare(this.length, o.length);
  }
}
