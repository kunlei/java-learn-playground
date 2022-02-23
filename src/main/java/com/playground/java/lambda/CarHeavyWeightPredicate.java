package com.playground.java.lambda;

import java.util.function.Predicate;

public class CarHeavyWeightPredicate implements Predicate<Car> {
  @Override
  public boolean test(Car car) {
    return car.getWeight() > 1000;
  }
}
