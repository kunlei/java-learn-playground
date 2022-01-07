package com.playground.java.generics.comparables.two;

public abstract class Fruit implements Comparable<Fruit> {
  protected String name;
  protected int size;

  protected Fruit(String name, int size) {
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
    return this.name.hashCode() * 29 + size;
  }

  @Override
  public int compareTo(Fruit o) {
    return Integer.compare(this.size, o.size);
  }
}
