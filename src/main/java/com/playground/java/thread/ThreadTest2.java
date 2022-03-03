package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "test2")
public class ThreadTest2 {
  public static void main(String[] args) {
    Runnable r = () -> log.debug("running");

    Thread t2 = new Thread(r, "t2");
    t2.start();

    log.debug("running");
  }
}
