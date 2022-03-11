package com.playground.java.thread.pool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyThreadPool {
  private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());
  private int num;
  private int corePoolSize;
  private int maxSize;
  private int workSize;

  public MyThreadPool(int corePoolSize, int maxSize, int workSize) {
    this.corePoolSize = corePoolSize;
    this.maxSize = maxSize;
    this.workSize = workSize;
  }

  public void submit(Runnable r) {
    if (tasks.size() >= workSize) {
      System.out.println("task: " + r + " submission failed");
    } else {
      tasks.add(r);
      executeTask(r);
    }
  }

  public void executeTask(Runnable r) {
    if (num < corePoolSize) {
      new MyWorker("coreThread: " + num, tasks).start();
      num++;
    } else if (num < maxSize) {
      new MyWorker("nonCoreThread: " + num, tasks).start();
    } else {
      System.out.println("task " + r + "execution failed");
    }
  }
}
