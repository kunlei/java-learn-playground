package com.playground.java.generics;

import java.util.*;

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

  public static void main(String[] args) {
    List<Integer> ints = Arrays.asList(1, 2, 3);
    int s = 0;
    for (Integer n : ints) {
      s += n;
    }
    assert s == 6;

    s = 0;
    for (Iterator<Integer> it = ints.iterator(); it.hasNext();) {
      s += it.next();
    }
    assert s == 6;

    List<String> words = new ArrayList<>();
    words.add("Hello ");
    words.add("world!");
    String ss = words.get(0) + words.get(1);

    Set<String> strings = new HashSet<>();

    assert ss.equals("Hello world!");

    SortedSet set;
    NavigableSet navigableSet;
  }
}
