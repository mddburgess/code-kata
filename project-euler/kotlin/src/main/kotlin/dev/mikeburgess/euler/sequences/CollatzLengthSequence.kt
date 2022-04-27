package dev.mikeburgess.euler.sequences

private val collatzLength = mutableMapOf(1L to 0L)

@OEIS("A006577")
fun collatzLengthSequence() =
    generateSequence(1L) { it + 1 }
        .map { computeCollatzLength(it) }

private fun computeCollatzLength(n: Long): Long {
    if (collatzLength[n] == null) {
        collatzLength[n] = when (n % 2) {
            0L -> 1 + computeCollatzLength(n / 2)
            else -> 2 + computeCollatzLength((3 * n + 1) / 2)
        }
    }
    return collatzLength[n]!!
}
