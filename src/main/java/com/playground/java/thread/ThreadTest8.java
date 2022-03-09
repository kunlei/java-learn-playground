package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTest8 {
  static int r = 0;
  public static void main(String[] args) throws InterruptedException {
    test1();
  }

  private static void test1() throws InterruptedException {
    log.debug("start");
    Thread t1 = new Thread("t1") {
      @Override
      public void run() {
        log.debug("start");
        try {
          sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.debug("end");
        r = 10;
      }
    };
    t1.start();
    t1.join();

    log.debug("result = {}", r);
    log.debug("end");
  }
}
