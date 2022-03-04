package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMultiThread {
  public static void main(String[] args) {
    new Thread(() -> {
      for (int i = 0; i < 1000000; i++) {
        log.debug("running");
      }
    }, "t1").start();

    new Thread(() -> {
      for (int i = 0; i < 100000; i++) {
        log.debug("running");
      }
    }, "t2").start();
  }

}
