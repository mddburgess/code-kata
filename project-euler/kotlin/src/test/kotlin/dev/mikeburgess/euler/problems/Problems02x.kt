package dev.mikeburgess.euler.problems

import dev.mikeburgess.euler.extensions.*
import dev.mikeburgess.euler.math.factorial
import dev.mikeburgess.euler.getResourceAsLines
import org.assertj.core.api.Assertions.assertThat
import java.math.BigInteger
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

    /**
     * Problem 23
     *
     * A perfect number is a number for which the sum of its proper divisors is exactly equal to the
     * number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
     * which means that 28 is a perfect number.
     *
     * A number n is called deficient if the sum of its proper divisors is less than n and it is
     * called abundant if this sum exceeds n.
     *
     * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can
     * be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be
     * shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
     * However, this upper limit cannot be reduced any further by analysis even though it is known
     * that the greatest number that cannot be expressed as the sum of two abundant numbers is less
     * than this limit.
     *
     * Find the sum of all the positive integers which cannot be written as the sum of two abundant
     * numbers.
     */
    @Test
    fun `Problem 23`() {
        val numbers = (0..28122).map { it.isAbundant() }

        fun Int.isSumOfTwoAbundant(): Boolean {
            for (i in 1..this / 2) {
                if (numbers[i] && numbers[this - i]) {
                    return true
                }
            }
            return false
        }

        val result = (1..28123)
            .filterNot { it.isSumOfTwoAbundant() }
            .sumOf { it.toLong() }

        assertThat(result).isEqualTo(4179871L)
    }

    /**
     * Problem 24
     *
     * A permutation is an ordered arrangement of objects. For example, 3124 is one possible
     * permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically
     * or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1
     * and 2 are:
     *
     * 012   021   102   120   201   210
     *
     * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8
     * and 9?
     */
    @Test
    fun `Problem 24`() {
        val digits = (0..9).toMutableList()
        var index = 999_999
        var value = 0L

        while (digits.size > 1) {
            val temp = factorial(digits.size - 1L).toInt()
            val i = index / temp
            index -= (i * temp)
            value = value * 10 + digits.removeAt(i)
        }
        val result = value * 10 + digits[0]

        assertThat(result).isEqualTo(2783915460L)
    }

    /**
     * Problem 25
     *
     * The Fibonacci sequence is defined by the recurrence relation:
     *
     * F(n) = F(n - 1) + F(n - 2), where F(1) = 1 and F(2) = 1.
     *
     * Hence the first 12 terms will be:
     *
     * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
     *
     * The 12th term, F(12), is the first term to contain three digits.
     *
     * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
     */
    @Test
    fun `Problem 25`() {
        var index = 2L
        var fibonacci = BigInteger.valueOf(1) to BigInteger.valueOf(1)
        while (fibonacci.second < BigInteger.TEN.pow(999)) {
            fibonacci = fibonacci.second to fibonacci.first + fibonacci.second
            index++
        }
        val result = index

        assertThat(result).isEqualTo(4782L)
    }

    /**
     * Problem 26
     *
     * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions
     * with denominators 2 to 10 are given:
     *
     * - 1/2  = 0.5
     * - 1/3  = 0.(3)
     * - 1/4  = 0.25
     * - 1/5  = 0.2
     * - 1/6  = 0.1(6)
     * - 1/7  = 0.(142857)
     * - 1/8  = 0.125
     * - 1/9  = 0.(1)
     * - 1/10 = 0.1
     *
     * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7
     * has a 6-digit recurring cycle.
     *
     * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal
     * fraction part.
     */
    @Test
    fun `Problem 26`() {
        val result = (1 until 1000L)
            .maxByOrNull { it.reciprocalCycleLength() }!!

        assertThat(result).isEqualTo(983L)
    }
}
