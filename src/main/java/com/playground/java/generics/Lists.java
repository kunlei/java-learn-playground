package com.playground.java.generics;

import java.util.ArrayList;
import java.util.List;

public class Lists {

  /**
   * generic method example that turns an array into a list
   * @param arr
   * @param <T>
   * @return
   */
  public static <T> List<T> toList(T[] arr) {
    List<T> list = new ArrayList<>();
    for (T elt : arr) {
      list.add(elt);
    }
    return list;
  }

  public static <T> List<T> toListVarargs(T... arr) {
    List<T> list = new ArrayList<>();
    for (T elt : arr) {
      list.add(elt);
    }
    return list;
  }

  public static void main(String[] args) {
    List<Integer> ints = Lists.toList(new Integer[]{1, 2, 3});
    List<String> words = Lists.toList(new String[]{"hello", "world"});

    List<Integer> newInts = Lists.toListVarargs(1, 2, 3);
    List<String> newWords = Lists.toListVarargs("hello", "word");
  }
}
