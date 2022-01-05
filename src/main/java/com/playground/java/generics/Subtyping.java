package com.playground.java.generics;

import java.util.*;

public class Subtyping {

  public static <E> void print(Iterable<E> iterable) {
    for (E e : iterable) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    Iterable<Integer> intIterable = Arrays.asList(1, 2, 3);
    Collection<Integer> intCollection = Arrays.asList(1, 2, 3);
    List<Integer> intList = Arrays.asList(1, 2, 3);

    print(intIterable);
    print(intCollection);
    print(intList);

    List<Number> numbers = Arrays.asList(1, 2, 3);
    List<Integer> integers = Arrays.asList(1, 2, 3);
  }
}
