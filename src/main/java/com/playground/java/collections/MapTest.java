package com.playground.java.collections;

import java.util.*;
import java.util.stream.Collectors;

public class MapTest {
  public static void main(String[] args) {
    Map<String, Integer> scores = new HashMap<>();
    scores.put("math", 90);
    scores.put("science", 80);
    System.out.println("map before compute: " + scores);

    scores.compute("math", (k, v) -> v + 1);
    System.out.println("map after compute: " + scores);

    scores.compute("math", (k, v) -> null);
    System.out.println("map after compute: " + scores);

    scores.compute("math", (k, v) -> 90);
    System.out.println("map after compute: " + scores);

    scores.compute("chemistry", (k, v) -> null);
    System.out.println("map after compute: " + scores);

    scores.computeIfPresent("math", (k, v) -> v + 2);
    System.out.println("map after computeIfPresent: " + scores);

    scores.computeIfPresent("chemistry", (k, v) -> v + 1);
    System.out.println("map after computeIfPresent: " + scores);

    scores.computeIfAbsent("math", k -> 100);
    System.out.println("map after computeIfAbsent: " + scores);

    scores.compute("history", (key, value) -> {
      if (value == null) {
        return 100;
      } else {
        value++;
        return value;
      }
    });
    System.out.println("map after computeIfAbsent: " + scores);

    System.out.println("map before merge(): " + scores);

    scores.merge("reading", 95, (oldValue, newValue) -> null);
    System.out.println("map after merge(): " + scores);

    scores.merge("reading", 90, (oldValue, newValue) -> oldValue);
    System.out.println("map after merge(): " + scores);

    scores.merge("reading", 90, (oldValue, newValue) -> newValue);
    System.out.println("map after merge(): " + scores);

    scores.merge("reading", 90, (oldValue, newValue) -> null);
    System.out.println("map after merge(): " + scores);

    new ArrayList<Integer>();

    superUsefulFunction("work");
//    superUsefulFunction(null);

//    Dictionary;

    Map<Integer, Set<String>> map = new HashMap<>();
    map.computeIfAbsent(1, key -> {
      Set<String> set = new HashSet<>();
      set.add("a");
      set.add("b");
      return set;
    });
    map.computeIfAbsent(2, key -> {
      Set<String> set = new HashSet<>();
      set.add("b");
      set.add("c");
      return set;
    });
    System.out.println(map);

    Map<String, List<String>> collect = map.values()
      .stream()
      .flatMap(Set::stream)
      .collect(Collectors.groupingBy(o -> o));
    System.out.println(collect);


  }

  public static void superUsefulFunction(String input) {
    Objects.requireNonNull(input, "input cannot be null!");
    System.out.println("do useful work!");
    System.out.println("print input: " + input);
  }
}
