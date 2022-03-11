package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

@Slf4j
public class ParkTest {
  public static void main(String[] args) throws InterruptedException {
    test();
  }

  private static void test() throws InterruptedException {
    Thread t1 = new Thread(() -> {
      log.debug("park...");
      LockSupport.park();
      log.debug("unpark...");
      log.debug("interruption state: {}", Thread.interrupted());

      LockSupport.park();
      log.debug("unpark...");
    }, "t1");
    t1.start();

    Thread.sleep(1000);
    t1.interrupt();
  }
}
