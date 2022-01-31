package com.playground.java.collections;

import java.util.Collections;
import java.util.List;

public class CollectionsTest {
  public static void main(String[] args) {
    List<Integer> integers = new java.util.ArrayList<>(List.of(1, 2, 3));
    integers.forEach(System.out::println);

    System.out.println();
    Collections.reverse(integers);
    integers.forEach(System.out::println);

    Collections.rotate(integers, 1);
    integers.forEach(System.out::println);
  }
}
