package com.playground.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Wildcards {
  public static void addAll(List<Number> source, Collection<? extends Number> input) {
    source.addAll(input);
  }

  public static void main(String[] args) {
    List<Number> numbers = new ArrayList<>();
    List<Integer> integers = Arrays.asList(1, 2, 3);
    List<Double> doubles = Arrays.asList(1.0, 2.0);
    numbers.addAll(integers);
    numbers.addAll(doubles);
    numbers.forEach(System.out::print);

    List<? extends Number> list;
    list = integers;
    list = doubles;

    addAll(numbers, integers);
    addAll(numbers, doubles);

    List<Number> nums = new ArrayList<>();
    List<? super Number> destination = nums;
    List<? extends Number> source = nums;
    for (int i = 0; i < 10; i++) {
      destination.add(i);
    }
    double sum = 0;
    for (Number num : source) {
      sum += num.doubleValue();
    }
  }
}
