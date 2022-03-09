package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "ThreadTest")
public class ThreadTest6 {
  public static void main(String[] args) throws InterruptedException {
    log.debug("enter sleep..");
    TimeUnit.SECONDS.sleep(1);
    log.debug("end sleep.");
  }
}
