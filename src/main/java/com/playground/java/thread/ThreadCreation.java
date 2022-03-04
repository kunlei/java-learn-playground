package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "TreadCreation")
public class ThreadCreation {
  public static void main(String[] args) {
    // create a new thread by extending the Thread class
    Thread t1 = new Thread() {
      @Override
      public void run() {
        log.debug("running within t1.");
      }
    };
    t1.setName("t1");

    // create a new thread by defining a runnable
    Runnable r = new Runnable() {
      @Override
      public void run() {
        log.debug("running within runnable.");
      }
    };
    Thread t2 = new Thread(r);
    t2.setName("t2");

    // create a thread using FutureTask
    FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        log.debug("running within future task.");
        return 0;
      }
    });
    Thread t3 = new Thread(futureTask);
    t3.setName("t3");

    t1.start();
    t2.start();
    t3.start();
  }
}
