package com.example.materialcalculator.domain

import com.google.common.truth.Truth
import org.junit.Test

class ExpressionEvaluatorTest {

  private lateinit var evaluator: ExpressionEvaluator

  @Test
  fun `Simple expression properly evaluated`() {
    evaluator = ExpressionEvaluator(
      listOf(
        ExpressionPart.Number(4.0),
        ExpressionPart.Op(Operation.ADD),
        ExpressionPart.Number(5.0),
        ExpressionPart.Op(Operation.SUBTRACT),
        ExpressionPart.Number(3.0),
        ExpressionPart.Op(Operation.MULTIPLY),
        ExpressionPart.Number(5.0),
        ExpressionPart.Op(Operation.DIVIDE),
        ExpressionPart.Number(3.0),
      )
    )

    Truth.assertThat(evaluator.evaluate()).isEqualTo(4)
  }

  @Test
  fun `Expression with decimals properly evaluated`() {
    evaluator = ExpressionEvaluator(
      listOf(
        ExpressionPart.Number(4.5),
        ExpressionPart.Op(Operation.ADD),
        ExpressionPart.Number(5.5),
        ExpressionPart.Op(Operation.SUBTRACT),
        ExpressionPart.Number(3.5),
        ExpressionPart.Op(Operation.MULTIPLY),
        ExpressionPart.Number(5.5),
        ExpressionPart.Op(Operation.DIVIDE),
        ExpressionPart.Number(3.5),
      )
    )

    Truth.assertThat(evaluator.evaluate()).isEqualTo(4.5)
  }

}
