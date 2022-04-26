package dev.mikeburgess.euler.sequences

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrimeSequenceTest {

    @Test
    fun `first 10 primes`() {
        assertThat(primeSequence().take(10).toList())
            .containsExactly(2L, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    }
}
