package com.playground.java.thread.pool;

import java.util.List;

public class MyWorker extends Thread {
  private String name;
  private List<Runnable> tasks;

  public MyWorker(String name, List<Runnable> tasks) {
    super(name);
    this.name = name;
    this.tasks = tasks;
  }

  @Override
  public void run() {
    while (tasks.size() > 0) {
      Runnable r = tasks.remove(0);
      r.run();
    }
  }
}
