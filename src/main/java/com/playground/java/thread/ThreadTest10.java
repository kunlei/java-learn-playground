package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "ThreadTest10")
public class ThreadTest10 {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(() -> {
      while (true) {
        boolean interrupted = Thread.currentThread().isInterrupted();
        if (interrupted) {
          log.debug("I'm interrupted, exit..");
          break;
        }
      }
    }, "t1");
    t1.start();

    Thread.sleep(1000);
    log.debug("interrupt t1...");
    t1.interrupt();
  }
}
