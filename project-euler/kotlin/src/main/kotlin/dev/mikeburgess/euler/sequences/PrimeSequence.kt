package dev.mikeburgess.euler.sequences

import kotlin.math.sqrt

val primes = linkedSetOf(2L, 3L)

@OEIS("A000040")
fun primeSequence() = sequence {
    yieldAll(primes)
    yieldAll(generateSequence(nextPrime(primes.last())) { nextPrime(it) })
}

private fun nextPrime(n: Long) =
    generateSequence(n + 2) { it + 2 }
        .filter { isPrime(it) }
        .first()
        .also { primes.add(it) }

private fun isPrime(n: Long) =
    primes.asSequence()
        .takeWhile { it <= sqrt(n.toDouble()) }
        .none { n % it == 0L }
