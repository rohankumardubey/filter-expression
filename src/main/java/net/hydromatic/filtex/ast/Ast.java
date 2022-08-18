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
package net.hydromatic.filtex.ast;

/** Various sub-classes of AST nodes. */
public class Ast {
  private Ast() {
  }

  /** Literal. */
  @SuppressWarnings("rawtypes")
  public static class Literal extends AstNode {
    public final Comparable value;

    Literal(Pos pos, Comparable value) {
      super(pos, Op.LITERAL);
      this.value = value;
    }

    @Override public String toString() {
      return String.valueOf(value);
    }
  }

  public static class Call extends AstNode {
    public Call(Op op, AstNode left, AstNode right) {
      super(Pos.ZERO, op);
    }
  }
}

// End Ast.java
