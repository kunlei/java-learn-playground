package com.playground.java.collections;

public abstract class Task implements Comparable<Task> {
  protected Task() {}

  @Override
  public boolean equals(Object o) {
    if (o instanceof Task) {
      return toString().equals(o.toString());
    } else {
      return false;
    }
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public int compareTo(Task o) {
    return toString().compareTo(o.toString());
  }

  public abstract String toString();
}
