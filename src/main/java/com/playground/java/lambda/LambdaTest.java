package com.playground.java.lambda;

import com.playground.java.generics.comparables.one.Apple;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
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

    Predicate<Car> redCarPredicate = c -> "read".equals(c.getColor());
    Predicate<Car> heavyCarPredicate = c -> c.getWeight() > 2000;
    List<Car> redCars = filter(inventory, redCarPredicate);
    List<Car> redAndHeavyCars = filter(inventory, redCarPredicate.and(heavyCarPredicate));
    List<Car> redOrHeavyCars = filter(inventory, redCarPredicate.or(heavyCarPredicate));

    List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
    Consumer<Integer> plus2 = System.out::println;
    Consumer<Integer> consumer;

    Function<String, Integer> f = s -> s.length();
    List<Integer> map = map(Arrays.asList("lambdas", "hello", "world"), f);

    IntPredicate evenNumbers = i -> i % 2 == 0;
    evenNumbers.test(1000);
  }

  public static void process(Runnable r) {
    r.run();
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> p) {
    List<T> results = new ArrayList<>();
    for (T t : list) {
      if (p.test(t)) {
        results.add(t);
      }
    }
    return results;
  }

  public static <T> void forEach(List<T> list, Consumer<T> c) {
    for (T t : list) {
      c.accept(t);
    }
  }

  public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
    List<R> result = new ArrayList<>();
    for (T t : list) {
      result.add(f.apply(t));
    }
    return result;
  }
}
