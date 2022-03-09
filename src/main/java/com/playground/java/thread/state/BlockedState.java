package com.playground.java.thread.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockedState {

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new DemoThread(), "t1");
    Thread t2 = new Thread(new DemoThread(), "t2");

    t1.start();
    t2.start();

    Thread.sleep(1000);

    log.info("t2 state = {}", t2.getState());
    System.exit(0);
  }

  public static class DemoThread implements Runnable {
    @Override
    public void run() {
      commonResource();
    }

    public static synchronized void commonResource() {
      while (true) {
        // infinite loop
      }
    }
  }
}
