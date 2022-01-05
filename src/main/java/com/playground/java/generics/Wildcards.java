package com.playground.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {
  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    List<Integer> integers = Arrays.asList(1, 2, 3);
    List<Double> doubles = Arrays.asList(1.0, 2.0);
    numbers.addAll(integers);
    numbers.addAll(doubles);
    numbers.forEach(System.out::print);

    List<Integer> ints = new ArrayList<>();
    ints.add(1);
    ints.add(2);
    List<? extends Number> nums = ints;
    nums.add(3);
  }
}
