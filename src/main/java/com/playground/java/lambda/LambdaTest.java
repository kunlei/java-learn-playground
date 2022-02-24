package com.playground.java.lambda;

import com.playground.java.generics.comparables.one.Apple;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {
  public static void main(String[] args) {
    List<Car> inventory = Arrays.asList(new Car("silver", 2000),
      new Car("white", 1800),
      new Car("red", 2200));

    List<Car> cars = Car.filterCars(inventory, new Predicate<Car>() {
      @Override
      public boolean test(Car car) {
        return "red".equals(car.getColor());
      }
    });

    List<Car> whiteCars = Car.filterCars(inventory, (Car car) -> "white".equals(car.getColor()));
  }

}
