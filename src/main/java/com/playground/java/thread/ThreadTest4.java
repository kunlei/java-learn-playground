package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadTest4 {
  public static void main(String[] args) {
    Thread t1 = new Thread("t1") {
      @Override
      public void run() {
        log.debug("enter sleeping...");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          log.debug("wake up...");
          e.printStackTrace();
        }
        log.debug("finish sleeping...");
      }
    };

    log.debug("t1 state: {}", t1.getState());

    t1.start();

    try {
      Thread.sleep(1000);

      log.debug("interrupt...");

      t1.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    log.debug("t1 state: {}", t1.getState());
  }
}
