package dev.mikeburgess.euler.math

import java.math.BigInteger

fun factorial(n: Long): BigInteger =
    (1..n).map(BigInteger::valueOf).reduce { a, b -> a * b }
