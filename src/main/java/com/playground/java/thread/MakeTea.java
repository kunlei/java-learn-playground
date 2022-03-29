package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.TableHeaderUI;

@Slf4j(topic = "MakeTea")
public class MakeTea {
  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      log.debug("洗水壶");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      log.debug("烧开水");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, "Wang");

    Thread t2 = new Thread(() -> {
      log.debug("洗茶壶");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      log.debug("洗茶杯");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      log.debug("拿茶叶");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      try {
        t1.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      log.debug("泡茶");

    }, "Xiao Wang");

    t1.start();
    t2.start();
  }
}
