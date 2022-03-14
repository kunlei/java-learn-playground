package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "DaemonThreadTest")
public class DaemonThreadTest {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      while (true) {
        if (Thread.currentThread().isInterrupted()) {
          break;
        }
      }
      log.debug("end within t1.");
    }, "t1");
    t1.setDaemon(true);
    t1.start();

    Thread.sleep(1000);
    log.debug("end");
  }
}
