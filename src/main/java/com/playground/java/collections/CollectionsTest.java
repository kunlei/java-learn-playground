package com.playground.java.collections;

import java.util.*;

public class CollectionsTest {
  public static void main(String[] args) {
    List<Integer> integers = new java.util.ArrayList<>(List.of(1, 2, 3));
    integers.forEach(System.out::println);

    System.out.println();
    Collections.reverse(integers);
    integers.forEach(System.out::println);

    Collections.rotate(integers, 1);
    integers.forEach(System.out::println);

    // test singleton collections
    Set<Integer> singletonSet = Collections.singleton(1);
    List<Integer> singletonList = Collections.singletonList(1);
    Map<Integer, Integer> singletonMap = Collections.singletonMap(1, 1);

    List<Integer> integerCopies = Collections.nCopies(5, 2);
    integerCopies.forEach(System.out::println);
  }

  public static List<Integer> getList(int size, int value) {
    if (size < 1) {
      return new ArrayList<>();
    }
    ArrayList<Integer> list = new ArrayList<>(size);
    Collections.fill(list, value);
    return list;
  }
}
