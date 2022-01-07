package com.playground.java.generics.comparables.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Fruit {
  protected String name;
  protected int size;

  public Fruit(String name, int size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Fruit) {
      Fruit that = (Fruit) o;
      return this.name.equals(that.name) && this.size == that.size;
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return name.hashCode() * 29 + size;
  }

  protected int compareTo(Fruit that) {
    return Integer.compare(this.size, that.size);
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
//    assert Collections.max(mixed).equals(o3);
  }
}
