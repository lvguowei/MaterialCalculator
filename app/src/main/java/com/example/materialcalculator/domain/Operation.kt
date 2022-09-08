package com.example.materialcalculator.domain

enum class Operation(val symbol: Char) {
  ADD('+'),
  SUBTRACT('-'),
  MULTIPLY('x'),
  DIVIDE('/'),
  PERCENT('%')
}

val operationSymbols = Operation.values().map { it.symbol }.joinToString("")

fun operationFromSymbol(symbol: Char) =
  Operation.values().find { it.symbol == symbol } ?: error("operation parsing error")
