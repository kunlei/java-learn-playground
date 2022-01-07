package com.playground.java.generics.comparables.one;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Comparables {
  public static void main(String[] args) {
    Integer int0 = 0;
    Integer int1 = 1;
    assert int0.compareTo(int1) < 0;

    List<Integer> ints = Arrays.asList(0, 1, 2);
    assert max(ints) == 2;
  }

  public static <T extends Comparable<T>> T max(Collection<T> coll) {
    T candidate = coll.iterator().next();
    for (T elt : coll) {
      if (candidate.compareTo(elt) < 0) {
        candidate = elt;
      }
    }
    return candidate;
  }
}
