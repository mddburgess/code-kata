package dev.mikeburgess.euler.sequences

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class CollatzLengthSequenceTest {

    @Test
    fun `first 10 Collatz lengths`() {
        assertThat(collatzLengthSequence().take(10).toList())
            .containsExactly(0, 1, 7, 2, 5, 8, 16, 3, 19, 6)
    }
}
