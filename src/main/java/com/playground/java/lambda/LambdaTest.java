package com.playground.java.lambda;

import com.playground.java.generics.comparables.one.Apple;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
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

    Comparator<Car> byWeight = new Comparator<Car>() {
      @Override
      public int compare(Car o1, Car o2) {
        return Comparator.comparingDouble(Car::getWeight).compare(o1, o2);
      }
    };

    Comparator<Car> byWeightLambda = (Car c1, Car c2) -> (int) (c1.getWeight() - c2.getWeight());

    Runnable r1 = () -> System.out.println("Hello World 1!");
    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("hello world 2!");
      }
    };
    process(r1);
    process(r2);

  }

  public static void process(Runnable r) {
    r.run();
  }

}
