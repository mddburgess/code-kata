package dev.mikeburgess.euler.sequences

@OEIS("A000045")
fun fibonacciSequence() =
    generateSequence(1L to 2L) { (a, b) -> b to a + b }
        .map { it.first }

@OEIS("A000217")
fun triangleNumbers() =
    generateSequence(1L to 2L) { (_, n) -> n * (n + 1) / 2 to n + 1 }
        .map { it.first }
