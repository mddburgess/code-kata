package dev.mikeburgess.euler.sequences

@OEIS("A000045")
fun fibonacciSequence() =
    generateSequence(1L to 2L) { (a, b) -> b to a + b }
        .map { it.first }
