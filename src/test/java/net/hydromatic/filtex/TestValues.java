/*
 * Licensed to Julian Hyde under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hydromatic.filtex;

import com.google.common.collect.ImmutableList;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/** Values shared among tests. */
public class TestValues {
  private TestValues() {}

  /** From
   * <a href="https://github.com/looker-open-source/components/blob/main/packages/filter-expressions/src/grammars/date_grammar_test_expressions.ts">
   * date_grammar_test_expressions.ts</a>. */
  public static final List<GrammarTestItem> DATE_EXPRESSION_TEST_ITEMS =
      GrammarTestItem.builder()
          .add4("3 days", "3 day", "is in the last 3 days", null)
          .add4("3 days", "3 day", "is in the last 3 days")
          .add4("3 days ago", "3 days ago", "is 3 days ago", "pastAgo")
          .add4("7 year ago", "7 year ago", "is 7 years ago", "pastAgo")
          .add4("3 months ago for 2 days", "3 month ago for 2 day",
              "is 3 months ago for 2 days")
          .add4("before 3 days ago", "before 3 day ago", "is before 3 days ago")
          .add4("before 2018-01-01 12:00:00", "before 2018/01/01",
              "is before 2018/01/01")
          .add4("after 2018-10-05", "after 2018/10/05",
              "is on or after 2018/10/05")
          .add4("2018-05-18 12:00:00 to 2018-05-18 14:00:00",
              "2018/05/18 to 2018/05/18", "is from 2018/05/18 until 2018/05/18")
          .add4("next week", "next week", "is next week")
          .add4("last week", "last week", "is previous week")
          .add4("not null", "not null", "is not null")
          .add4("null", "null", "is null")
          .add4("2018-05-18", "2018/05/18", "is on 2018/05/18")
          .add4("", "", "is any time")
          .add4("2018", "2018", "is in the year 2018")
          .add4("2018/01", "2018-01", "is in January 2018")
          .add4("monday", "monday", "is monday")
          .add4("before 2 months from now", "before 2 month from now",
              "is before 2 months from now")
          .add4("after 2 weeks from now", "after 2 week from now",
              "is on or after 2 weeks from now")
          .add4("after 1 month ago", "after 1 month ago",
              "is on or after 1 month ago")
          .add4("this year to second", "this year to second",
              "this year to second", "thisRange")
          .add4("this year to day", "this year to day", "this year to day",
              "thisRange")

          // this
          .add4("this day", "this day", "is this day", "this")
          .add4("this week", "this week", "is this week", "this")
          .add4("this month", "this month", "is this month", "this")
          .add4("this quarter", "this quarter", "is this quarter", "this")
          .add4("this fiscal quarter", "this fiscal quarter",
              "is this fiscal quarter", "this")
          .add4("this year", "this year", "is this year", "this")
          .add4("this fiscal year", "this fiscal year", "is this fiscal year",
              "this")

          // next
          .add4("next day", "next day", "is next day", "next")
          .add4("next week", "next week", "is next week", "next")
          .add4("next month", "next month", "is next month", "next")
          .add4("next quarter", "next quarter", "is next quarter", "next")
          .add4("next fiscal quarter", "next fiscal quarter",
              "is next fiscal quarter", "next")
          .add4("next year", "next year", "is next year", "next")
          .add4("next fiscal year", "next fiscal year", "is next fiscal year",
              "next")

          // last
          .add4("last second", "last second", "is previous second", "last")
          .add4("last minute", "last minute", "is previous minute", "last")
          .add4("last hour", "last hour", "is previous hour", "last")
          .add4("last day", "last day", "is previous day", "last")
          .add4("last week", "last week", "is previous week", "last")
          .add4("last month", "last month", "is previous month", "last")
          .add4("last quarter", "last quarter", "is previous quarter", "last")
          .add4("last fiscal quarter", "last fiscal quarter",
              "is previous fiscal quarter", "last")
          .add4("last year", "last year", "is previous year", "last")
          .add4("last fiscal year", "last fiscal year",
              "is previous fiscal year", "last")

          // before this/next/last
          .add4("before this day", "before this day", "before this day",
              "before_this")
          .add4("before this week", "before this week", "before this week",
              "before_this")
          .add4("before this month", "before this month", "before this month",
              "before_this")

          .add4("before next day", "before next day", "before next day",
              "before_next")
          .add4("before next quarter", "before next quarter",
              "before next quarter", "before_next")
          .add4("before next year", "before next year", "before next year",
              "before_next")

          .add4("before last day", "before last day", "before last day",
              "before_last")
          .add4("before last week", "before last week", "before last week",
              "before_last")
          .add4("before last month", "before last month", "before last month",
              "before_last")

          // after this/next/last
          .add4("after this day", "after this day", "after this day",
              "after_this")
          .add4("after this week", "after this week", "after this week",
              "after_this")
          .add4("after this month", "after this month", "after this month",
              "after_this")

          .add4("after next day", "after next day", "after next day",
              "after_next")
          .add4("after next week", "after next week", "after next week",
              "after_next")
          .add4("after next month", "after next month", "after next month",
              "after_next")

          .add4("after last day", "after last day", "after last day",
              "after_last")
          .add4("after last quarter", "after last quarter",
              "after last quarter", "after_last")
          .add4("after last year", "after last year", "after last year",
              "after_last")
          .build();

  /** From
   * <a href="https://github.com/looker-open-source/components/blob/main/packages/filter-expressions/src/grammars/location_grammar.spec.ts">
   * location_grammar.spec.ts</a>. */
  public static final List<Triple> LOCATION_EXPRESSION_TEST_ITEMS =
      Triple.builder()
          .add("36.97, -122.03", "36.97, -122.03",
              "{lat=36.97, long=-122.03, type=location}")
          .add("-36.97, 122.03", "-36.97, 122.03",
              "{lat=-36.97, long=122.03, type=location}")
          .add("-36.97, -122.03", "-36.97, -122.03",
              "{lat=-36.97, long=-122.03, type=location}")
          .add("40 miles from -36.97, -122.03", "40 miles from -36.97, -122.03",
              "{distance=40, lat=-36.97, lon=-122.03, type=circle, unit=miles}")
          .add("40 miles from 36.97, -122.03", "40 miles from 36.97, -122.03",
              "{distance=40, lat=36.97, lon=-122.03, type=circle, unit=miles}")
          .add("100 miles from 36.97, -122.03", "100 miles from 36.97, -122.03",
              "{distance=100, lat=36.97, lon=-122.03, type=circle, unit=miles}")
          .add("inside box from 72.33, -173.14 to 14.39, -61.70",
              "72.3°N, 173.1°W to 14.4°N, 61.7°W",
              "{lat=72.33, lat1=14.39, lon=-173.14, lon1=-61.70, type=box}")
          .add("", "is anywhere", null)
          .add("NOT NULL", "is not null", "{type=notnull}")
          .add("-NULL", "is not null", "{type=notnull}")
          .add("NULL", "is null", "{type=null}")
          .build();

  /** From
   * <a href="https://github.com/looker-open-source/components/blob/main/packages/filter-expressions/src/grammars/number_grammar_test_expressions.ts">
   * number_grammar_test_expressions.ts</a>. */
  public static final List<GrammarTestItem> NUMBER_EXPRESSION_TEST_ITEMS =
      GrammarTestItem.builder()
          .add("5", "=", "is 5", "5")
          .add("not 5", "!=", "is not 5", "not 5")
          .add("<> 5", "!=", "is not 5", "not 5")
          .add("1, 3, 5, 7", "=", "is 1 or 3 or 5 or 7", "1,3,5,7")
          .add("not 66, 99, 4", "!=", "is not 66 or 99 or 4",
              "not 66,not 99,not 4")
          .add("5.5 to 10", "between", "is in range [5.5, 10]", "[5.5,10]")
          .add("not 3 to 80.44", "!between",
              "is not in range [3, 80.44]", "not [3,80.44]")
          .add("1 to", ">=", "is >= 1", ">=1")
          .add("to 100", "<=", "is <= 100", "<=100")
          .add(">= 5.5 AND <=10", "between",
              "is in range [5.5, 10]", "[5.5,10]")
          .add("<3 OR >80.44", "!between",
              "is not in range (3, 80.44)", "not (3,80.44)")
          .add(">10 AND <=20 OR 90", "between",
              "is in range (10, 20] or is 90", "(10,20],90")
          .add(">=50 AND <=100 OR >=500 AND <=1000", "between",
              "is in range [50, 100] or is in range [500, 1000]",
              "[50,100],[500,1000]")
          .add("NULL", "null", "is null", "null")
          .add("NOT NULL", "!null", "is not null", "not null")
          .add("(1,100)", "between", "is in range (1, 100)", "(1,100)")
          .add("(1,100]", "between", "is in range (1, 100]", "(1,100]")
          .add("[1,100)", "between", "is in range [1, 100)", "[1,100)")
          .add("[1,100]", "between", "is in range [1, 100]", "[1,100]")
          .add("[0,9],[20,29]", "between",
              "is in range [0, 9] or is in range [20, 29]", "[0,9],[20,29]")
          .add("[0,10],20", "between", "is in range [0, 10] or is 20",
              "[0,10],20")
          .add("NOT 10,[1,5)", "between", "is in range [1, 5), and is not 10",
              "[1,5),not 10")
          .add("(1,100],500,600,(800,900],[2000,)", "between",
              "is in range (1, 100] or is 500 or 600 or is in range (800, 900] or is >= 2000",
              "(1,100],500,600,(800,900],>=2000")
          .add("(1, inf)", ">", "is > 1", ">1")
          .add("(1,)", ">", "is > 1", ">1")
          .add("(-inf,100]", "<=", "is <= 100", "<=100")
          .add("(,100)", "<", "is < 100", "<100")
          .add("[,10]", "<=", "is <= 10", "<=10")
          .add(">5", ">", "is > 5", ">5")
          .add("23, not 42, not 42", "=", "is 23, and is not 42",
              "23,not 42,not 42")
          .add("23, not 42, 43", "!=", "is not 23 or 42 or 43",
              "not 23,not 42,not 43")
          .add("23, not 42, not 43", "=", "is 23, and is not 42 or 43",
              "23,not 42,not 43")
          .add("23,NOT [30,40]", "=", "is 23, and is not in range [30, 40]",
              "23,not [30,40],not [30,40]")
          .add("23,NOT NULL", "=", "is 23, and is not null",
              "23,not null,not null")
          .add("23,NOT NULL,NOT NULL", "=", "is 23, and is not null",
              "23,not null,not null")
          .build();

  /** Runs a set of tests. */
  static <E> void forEach(Iterable<E> iterable, Consumer<E> consumer) {
    for (E e : iterable) {
      try {
        consumer.accept(e);
      } catch (AssertionError | RuntimeException x) {
        throw new RuntimeException("Failed '" + e + "'", x);
      }
    }
  }

  static class GrammarTestItem {
    final String expression;
    final String type;
    final @Nullable String low;
    final @Nullable String high;
    final @Nullable String bounds;
    final @Nullable String describe;
    final @Nullable String output;
    final @Nullable String digest;

    GrammarTestItem(String expression, String type, @Nullable String low,
        @Nullable String high, @Nullable String bounds,
        @Nullable String describe, @Nullable String output,
        @Nullable String digest) {
      this.expression = expression;
      this.type = type;
      this.low = low;
      if (Objects.equals(high, ".75")) {
        // FIXME figure out why number_grammar.spec.ts is inconsistent
        high = "0.75";
      }
      this.high = high;
      if (expression.equals("<7 OR >80.44")) {
        // FIXME figure out why number_grammar.spec.ts has "()"
        bounds = "[]";
      }
      this.bounds = bounds;
      this.describe = describe;
      this.output = output;
      this.digest = digest;
    }

    static ListBuilder builder() {
      return new ListBuilder();
    }

    @Override public String toString() {
      return expression;
    }

    /** Builds a list of {@link GrammarTestItem}. */
    public static class ListBuilder {
      final ImmutableList.Builder<GrammarTestItem> b = ImmutableList.builder();

      public ListBuilder add(String expression, String type, String describe,
          String output) {
        return add(expression, type, null, null, null, describe, output);
      }

      public ListBuilder add4(String expression, String output, String describe,
          String type) {
        return add(expression, type, describe, output);
      }

      public ListBuilder add4(String expression, String output,
          String describe) {
        return add(expression, "", null, null, null, describe, output);
      }

      public ListBuilder add(String expression, String type, String low,
          String high, String bounds) {
        return add(expression, type, low, high, bounds, null, null);
      }

      public ListBuilder add(String expression, String type,
          @Nullable String low, @Nullable String high, @Nullable String bounds,
          @Nullable String describe, @Nullable String output) {
        b.add(
            new GrammarTestItem(expression, type, low, high, bounds, describe,
                output, null));
        return this;
      }

      public ImmutableList<GrammarTestItem> build() {
        return b.build();
      }
    }
  }

  static class Triple {
    final String expression;
    final String type;
    final String textInput;

    Triple(String expression, String type, String textInput) {
      this.expression = expression;
      this.type = type;
      this.textInput = textInput;
    }

    public static ListBuilder builder() {
      return new ListBuilder();
    }

    @Override public String toString() {
      return expression + ":" + type + ":" + textInput;
    }

    /** Builds a list of {@link Triple}. */
    public static class ListBuilder {
      final ImmutableList.Builder<Triple> b = ImmutableList.builder();

      public ListBuilder add(String expression, String type, String textInput) {
        b.add(new Triple(expression, type, textInput));
        return this;
      }

      public ImmutableList<Triple> build() {
        return b.build();
      }
    }
  }

  static class Pair {
    final String expression;
    final String type;

    Pair(String expression, String type) {
      this.expression = expression;
      this.type = type;
    }

    public static ListBuilder builder() {
      return new ListBuilder();
    }

    @Override public String toString() {
      return expression + ":" + type;
    }
  }

  /** Builds a list of {@link Triple}. */
  public static class ListBuilder {
    final ImmutableList.Builder<Pair> b = ImmutableList.builder();

    public ListBuilder add(String expression, String type) {
      b.add(new Pair(expression, type));
      return this;
    }

    public ImmutableList<Pair> build() {
      return b.build();
    }
  }
}

// End TestValues.java
