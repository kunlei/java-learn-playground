package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ThreadTest")
public class ThreadTest5 {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread("t1") {
      @Override
      public void run() {
        log.debug("enter sleep...");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          log.debug("waking up...");
          e.printStackTrace();
        }
      }
    };
    t1.start();

    Thread.sleep(1000);
    log.debug("interrupt...");
    t1.interrupt();
  }
}
