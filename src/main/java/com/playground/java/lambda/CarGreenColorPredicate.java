package com.playground.java.lambda;

import java.util.function.Predicate;

public class CarGreenColorPredicate implements Predicate<Car> {
  @Override
  public boolean test(Car car) {
    return "green".equals(car.getColor());
  }
}
