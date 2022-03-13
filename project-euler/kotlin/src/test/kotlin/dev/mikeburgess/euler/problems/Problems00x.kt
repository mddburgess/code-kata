package dev.mikeburgess.euler.problems

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Problems00x {

    /**
     * Problem 1
     *
     * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6
     * and 9. The sum of these multiples is 23.
     *
     * Find the sum of all the multiples of 3 or 5 below 1000.
     */
    @Test
    fun `Problem 1`() {
        val result = (1 until 1000L)
            .filter { it % 3 == 0L || it % 5 == 0L }
            .sum()

        assertThat(result).isEqualTo(233168L)
    }
}
