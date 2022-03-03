package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "Test1")
public class ThreadTest1 {
  public static void main(String[] args) {
    Thread t = new Thread() {
      @Override
      public void run() {
        log.debug("running");
      }
    };
    t.setName("t1");
    // start the thread
    t.start();

    log.debug("running");
  }
}
