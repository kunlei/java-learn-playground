package com.playground.java.lambda;

import java.util.function.Predicate;

public class CarRedAndHeavyPredicate implements Predicate<Car> {
  @Override
  public boolean test(Car car) {
    return "red".equals(car.getColor()) && car.getWeight() > 2000;
  }
}
