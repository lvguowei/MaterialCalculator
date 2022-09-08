package com.example.materialcalculator.domain

import com.google.common.truth.Truth
import org.junit.Test


class ExpressionWriterTest {
  private lateinit var writer: ExpressionWriter

  @Test
  fun `initial parentheses parsed`() {
    writer = ExpressionWriter()
    writer.processAction(CalculatorAction.Parentheses)
    writer.processAction(CalculatorAction.Number(5))
    writer.processAction(CalculatorAction.Op(Operation.ADD))
    writer.processAction(CalculatorAction.Number(4))
    writer.processAction(CalculatorAction.Parentheses)

    Truth.assertThat(writer.expression).isEqualTo("(5+4)")
  }

  @Test
  fun `Closing parentheses at the start not parsed`() {
    writer = ExpressionWriter()
    writer.processAction(CalculatorAction.Parentheses)
    writer.processAction(CalculatorAction.Parentheses)

    Truth.assertThat(writer.expression).isEqualTo("((")
  }

  @Test
  fun `Parentheses around a number are parsed`() {
    writer = ExpressionWriter()
    writer.processAction(CalculatorAction.Parentheses)
    writer.processAction(CalculatorAction.Number(5))
    writer.processAction(CalculatorAction.Parentheses)

    Truth.assertThat(writer.expression).isEqualTo("(5)")

  }
}
