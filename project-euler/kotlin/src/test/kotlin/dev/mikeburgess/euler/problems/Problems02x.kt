package dev.mikeburgess.euler.problems

import dev.mikeburgess.euler.extensions.properDivisors
import dev.mikeburgess.euler.math.factorial
import dev.mikeburgess.euler.extensions.sumDigits
import dev.mikeburgess.euler.extensions.wordScore
import dev.mikeburgess.euler.getResourceAsLines
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class Problems02x {

    /**
     * Problem 20
     *
     * n! means n × (n − 1) × ... × 3 × 2 × 1
     *
     * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
     * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
     *
     * Find the sum of the digits in the number 100!
     */
    @Test
    fun `Problem 20`() {
        val result = factorial(100).sumDigits().toLong()

        assertThat(result).isEqualTo(648L)
    }

    /**
     * Problem 21
     *
     * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide
     * evenly into n).
     *
     * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b
     * are called amicable numbers.
     *
     * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
     * therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
     *
     * Evaluate the sum of all the amicable numbers under 10000.
     */
    @Test
    fun `Problem 21`() {
        val sums = (1..9999).associateWith { it.properDivisors.sum() }
        val result = sums.filter { (a, b) -> a != b }
            .mapValues { (_, b) -> sums[b] }
            .filter { (a, b) -> a == b }
            .keys.sum().toLong()

        assertThat(result).isEqualTo(31626L)
    }

    /**
     * Problem 22
     *
     * Using a text file containing over five-thousand first names, begin by sorting it into
     * alphabetical order. Then working out the alphabetical value for each name, multiply this
     * value by its alphabetical position in the list to obtain a name score.
     *
     * For example, when the list is sorted into alphabetical order, COLIN, which is worth
     * 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of
     * 938 × 53 = 49714.
     *
     * What is the total of all the name scores in the file?
     */
    @Test
    fun `Problem 22`() {
        val result = getResourceAsLines("Problem022.txt")
            .sorted()
            .mapIndexed { index, name -> (index + 1L) * name.wordScore }
            .sum()

        assertThat(result).isEqualTo(871198282L)
    }
}
