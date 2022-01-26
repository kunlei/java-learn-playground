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
    EnumSet<Fruit> fruits = EnumSet.allOf(Fruit.class);
    fruits.forEach(System.out::print);

    System.out.println();
    EnumSet<Fruit> emptyFruit = EnumSet.noneOf(Fruit.class);
    emptyFruit.forEach(System.out::print);

    System.out.println();
    EnumSet<Fruit> noApple = EnumSet.complementOf(EnumSet.of(Fruit.APPLE));
    noApple.forEach(System.out::print);

    System.out.println();
    EnumSet<Fruit> range = EnumSet.range(Fruit.JUICE, Fruit.AVACADO);
    range.forEach(System.out::print);

    EnumSet<Fruit> twoFruits = EnumSet.of(Fruit.BANANA, Fruit.WATERMELON);
    twoFruits.forEach(System.out::print);
  }
}
