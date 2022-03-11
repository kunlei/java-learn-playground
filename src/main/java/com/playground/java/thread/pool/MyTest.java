package com.playground.java.thread.pool;

import java.net.Inet4Address;
import java.util.concurrent.*;

public class MyTest {
  public static void main(String[] args) {
    test2();
  }

  public static void test1() {
    ExecutorService es = Executors.newCachedThreadPool();

    for (int i = 0; i < 10; i++) {
      es.submit(new MyRunnable());
    }
    es.shutdown();

    Future<Integer> future;
  }

  public static void test2() {
    ExecutorService es = Executors.newCachedThreadPool(new ThreadFactory() {
      int n = 1;
      @Override
      public Thread newThread(Runnable r) {
        return new Thread(r, "UserDefinedThread-" + n++);
      }
    });

    for (int i = 0; i < 10; i++) {
      es.submit(new MyRunnable());
    }
  }
}

class MyRunnable implements Runnable {
  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("threadName = " + name);
  }
}
