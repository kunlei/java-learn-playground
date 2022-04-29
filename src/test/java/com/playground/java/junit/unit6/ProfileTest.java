package com.playground.java.junit.unit6;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileTest {
  private Profile profile;
  private BooleanQuestion question;
  private Criteria criteria;

  @BeforeEach
  public void create() {
    profile = new Profile("Bull Hockey, Inc");
    question = new BooleanQuestion(1, "Got bonuses?");
    criteria = new Criteria();
  }

  @Test
  public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
    Answer profileAnswer = new Answer(question, Bool.FALSE);
    profile.add(profileAnswer);

    Answer criteriaAnswer = new Answer(question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
    criteria.add(criterion);

    boolean matches = profile.matches(criteria);
    assertFalse(matches);
  }

  @Test
  public void matchAnswersTrueForAnyDontCareCriteria() {
    Answer profileAnswer = new Answer(question, Bool.FALSE);
    profile.add(profileAnswer);

    Answer criteriaAnswer = new Answer(question, Bool.TRUE);
    Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
    criteria.add(criterion);
    boolean matches = profile.matches(criteria);
    assertTrue(matches);
  }

}