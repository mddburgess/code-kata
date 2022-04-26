package dev.mikeburgess.euler.problems

import dev.mikeburgess.euler.sequences.primeSequence
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class Problems01x {

    /**
     * Problem 10
     *
     * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     *
     * Find the sum of all the primes below two million.
     */
    @Test
    fun `Problem 10`() {
        val result = primeSequence()
            .takeWhile { it < 2_000_000 }
            .sum()

        assertThat(result).isEqualTo(142913828922L)
    }
}
