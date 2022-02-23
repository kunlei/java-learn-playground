package com.playground.java.lambda;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter
public class Car {
  private String color;
  private double weight;

  public static List<Car> filterCars(List<Car> inventory, Predicate<Car> predicate) {
    List<Car> result = new ArrayList<>();
    for (Car car : inventory) {
      if (predicate.test(car)) {
        result.add(car);
      }
    }
    return result;
  }

  public static List<Car> filterGreenCars(List<Car> inventory) {
    List<Car> result = new ArrayList<>();
    for (Car car : inventory) {
      if ("green".equals(car.getColor())) {
        result.add(car);
      }
    }
    return result;
  }

  public static List<Car> filterCarsByColor(List<Car> inventory, String color) {
    List<Car> result = new ArrayList<>();
    for (Car car : inventory) {
      if (car.getColor().equals(color)) {
        result.add(car);
      }
    }
    return result;
  }

  public static List<Car> filterHeavyCars(List<Car> inventory) {
    List<Car> result = new ArrayList<>();
    for (Car car : inventory) {
      if (car.getWeight() > 150) {
        result.add(car);
      }
    }
    return result;
  }

  public static List<Car> filterCarsByWeight(List<Car> inventory, int weight) {
    List<Car> result = new ArrayList<>();
    for (Car car : inventory) {
      if (car.getWeight() > weight) {
        result.add(car);
      }
    }
    return result;
  }

  public static boolean isGreenCar(Car car) {
    return "green".equals(car.getColor());
  }

  public static boolean isHeavyCar(Car car) {
    return car.getWeight() > 150;
  }
}
