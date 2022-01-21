package com.playground.java.collections;

public class CodingTask extends Task {
  private final String spec;

  public CodingTask(String spec) {
    this.spec = spec;
  }

  public String getSpec() {
    return spec;
  }

  @Override
  public String toString() {
    return "code " + spec;
  }
}
