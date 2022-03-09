package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Interrupt test")
public class ThreadTest9 {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      log.debug("sleep...");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        log.debug("wake up.");
        e.printStackTrace();
      }
    }, "t1");

    t1.start();
    log.debug("interruption flag: {}", t1.isInterrupted());

    Thread.sleep(1000);
    log.debug("interrupt");
    t1.interrupt();
    Thread.sleep(5);
    log.debug("interruption flag: {}", t1.isInterrupted());
  }
}
