package com.playground.java.generics.comparables.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Orange extends Fruit {
  public Orange(int size) {
    super("Orange", size);
  }

  public static void main(String[] args) {
    Apple a1 = new Apple(1);
    Apple a2 = new Apple(2);
    Orange o3 = new Orange(3);
    Orange o4 = new Orange(4);

    List<Apple> apples = Arrays.asList(a1, a2);
    assert Collections.max(apples).equals(a2);

    List<Orange> oranges = Arrays.asList(o3, o4);
    assert Collections.max(oranges).equals(o4);

    List<Fruit> mixed = Arrays.asList(a1, o3);
    assert Collections.max(mixed).equals(o3);
  }
}
