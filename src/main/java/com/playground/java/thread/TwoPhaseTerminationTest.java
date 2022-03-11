package com.playground.java.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoPhaseTerminationTest {
  public static void main(String[] args) throws InterruptedException {
    TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
    twoPhaseTermination.start();

    Thread.sleep(3500);
    twoPhaseTermination.stop();
  }
}

@Slf4j(topic = "TwoPhaseTermination")
class TwoPhaseTermination {
  private Thread monitor;

  public void start() {
    monitor = new Thread(() -> {
      while (true) {
        Thread thread = Thread.currentThread();
        if (thread.isInterrupted()) {
          log.debug("post-termination processing");
          break;
        } else {
          try {
            Thread.sleep(1000);
            log.debug("executing monitor log");
          } catch (InterruptedException e) {
            e.printStackTrace();
//            thread.interrupt();
          }
        }
      }
    });
    monitor.start();
  }

  public void stop() {
    monitor.interrupt();
  }
}
