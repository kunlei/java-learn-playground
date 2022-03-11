package com.playground.java.thread.pool;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyTask implements Runnable {
  private int id;

  public MyTask(int id) {
    this.id = id;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    log.debug("thread: {} to start executing", name);
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.debug("thread: {} finishes execution", name);
  }

  @Override
  public String toString() {
    return "MyTask{" +
      "id=" + id +
      '}';
  }
}
