package com.playground.java.junit;

import com.playground.java.junit.unit1.ScoreCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCollectionTest {

  @Test
  void arithmeticMean() throws Exception {
  }

  @Test
  public void answerArithmeticMeanOfTwoNumbers() {
    // arrange
    ScoreCollection collection = new ScoreCollection();
    collection.add(() -> 5);
    collection.add(() -> 7);

    // act
    int actualResult = collection.arithmeticMean();

    // assert
    assertEquals(actualResult, 6);
  }
}