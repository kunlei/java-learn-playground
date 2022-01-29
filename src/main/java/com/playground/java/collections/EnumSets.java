package com.playground.java.collections;

import com.playground.java.generics.comparables.one.Apple;

import java.util.EnumSet;

public class EnumSets {
  public enum Fruit {
    APPLE,
    JUICE,
    BANANA,
    ORANGE,
    PEAR,
    AVACADO,
    WATERMELON;
  }

  public static void main(String[] args) {
    EnumSet<Fruit> allFruits = EnumSet.allOf(Fruit.class);
    allFruits.forEach(System.out::println);

    System.out.println();
    EnumSet<Fruit> noFruits = EnumSet.noneOf(Fruit.class);
    noFruits.forEach(System.out::println);

    System.out.println();
    EnumSet<Fruit> noApple = EnumSet.complementOf(EnumSet.of(Fruit.APPLE));
    noApple.forEach(System.out::println);

    System.out.println();
    EnumSet<Fruit> range = EnumSet.range(Fruit.JUICE, Fruit.AVACADO);
    range.forEach(System.out::println);

    EnumSet<Fruit> twoFruits = EnumSet.of(Fruit.BANANA, Fruit.WATERMELON);
    twoFruits.forEach(System.out::println);

  }
}
