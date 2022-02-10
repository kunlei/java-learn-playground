package com.playground.java.collections;

import java.util.HashMap;
import java.util.Map;

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
  }
}
