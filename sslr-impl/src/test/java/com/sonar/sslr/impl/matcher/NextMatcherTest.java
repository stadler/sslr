/*
 * Copyright (C) 2010 SonarSource SA
 * All rights reserved
 * mailto:contact AT sonarsource DOT com
 */

package com.sonar.sslr.impl.matcher;

import static com.sonar.sslr.impl.matcher.HamcrestMatchMatcher.match;
import static com.sonar.sslr.impl.matcher.Matchers.and;
import static com.sonar.sslr.impl.matcher.Matchers.next;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class NextMatcherTest {

  @Test
  public void ok() {
    assertThat(and(next("one"), "one"), match("one"));
    assertThat(and(next("two"), "one"), not(match("one")));
  }

  @Test
  public void testGetDefinition() {
  	assertEquals("next(\"extends\")", next("extends").getDefinition());
    assertEquals("next(and(\"extends\", \"implements\"))", next("extends", "implements").getDefinition());
  }
}
