package dev.mikeburgess.euler.extensions

import java.math.BigInteger

fun BigInteger.sumDigits() =
    toString().sumOf { it - '0' }
