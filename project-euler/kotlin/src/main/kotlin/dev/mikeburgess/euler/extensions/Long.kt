package dev.mikeburgess.euler.extensions

import dev.mikeburgess.euler.sequences.primeSequence
import kotlin.math.sqrt

fun Long.countDivisors() = when (this) {
    1L -> 1
    2L, 3L -> 2
    else -> primeSequence()
        .takeWhile { it <= sqrt(toDouble()) }
        .map { countFactors(it) + 1 }
        .reduce { a, b -> a * b }
}

fun Long.countFactors(n: Long): Int {
    var count = 0
    var temp = this
    while (temp % n == 0L) {
        temp /= n
        count++
    }
    return count
}

fun Long.isEven() = this % 2 == 0L

fun Long.isPalindrome(base: Long = 10L): Boolean {
    var temp = this
    var reverse = 0L

    while (temp > 0) {
        reverse = reverse * base + (temp % base)
        temp /= base
    }

    return this == reverse
}

fun Long.reciprocalCycleLength(): Long {
    val remainders = mutableMapOf<Long, Long>()
    var i = 1L
    var position = 1L

    do {
        remainders[i] = position++
        i = (i % this) * 10
    } while (i != 0L && remainders[i] == null)

    return when (i) {
        0L -> 0L
        else -> position - remainders[i]!!
    }
}

fun Long.squared() = this * this
