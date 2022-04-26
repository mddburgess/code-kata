package dev.mikeburgess.euler.problems

import dev.mikeburgess.euler.extensions.isEven
import dev.mikeburgess.euler.extensions.isPalindrome
import dev.mikeburgess.euler.extensions.squared
import dev.mikeburgess.euler.math.lcm
import dev.mikeburgess.euler.sequences.fibonacciSequence
import dev.mikeburgess.euler.sequences.primeSequence
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

    /**
     * Problem 2
     *
     * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By
     * starting with 1 and 2, the first 10 terms will be:
     *
     * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
     *
     * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
     * find the sum of the even-valued terms.
     */
    @Test
    fun `Problem 2`() {
        val result = fibonacciSequence()
            .takeWhile { it < 4_000_000 }
            .filter { it.isEven() }
            .sum()

        assertThat(result).isEqualTo(4613732L)
    }

    /**
     * Problem 3
     *
     * The prime factors of 13195 are 5, 7, 13 and 29.
     *
     * What is the largest prime factor of the number 600851475143?
     */
    @Test
    fun `Problem 3`() {
        var number = 600_851_475_143
        var factor = 2L
        while (factor < number) {
            when {
                number % factor == 0L -> number /= factor
                else -> factor++
            }
        }

        assertThat(factor).isEqualTo(6857L)
    }

    /**
     * Problem 4
     *
     * A palindromic number reads the same both ways. The largest palindrome made from the product
     * of two 2-digit numbers is 9009 = 91 × 99.
     *
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */
    @Test
    fun `Problem 4`() {
        val result = (100..999L)
            .associateWith { it..999L }
            .flatMap { entry -> entry.value.map { entry.key * it } }
            .filter { it.isPalindrome() }
            .maxOf { it }

        assertThat(result).isEqualTo(906609L)
    }

    /**
     * Problem 5
     *
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without
     * any remainder.
     *
     * What is the smallest positive number that is evenly divisible by all of the numbers from
     * 1 to 20?
     */
    @Test
    fun `Problem 5`() {
        val result = (1..20L)
            .reduce { x, y -> lcm(x, y) }

        assertThat(result).isEqualTo(232792560L)
    }

    /**
     * Problem 6
     *
     * The sum of the squares of the first ten natural numbers is,
     *
     * 1^2 + 2^2 + ... + 10^2 = 385
     *
     * The square of the sum of the first ten natural numbers is,
     *
     * (1 + 2 + ... + 10)^2 = 552 = 3025
     *
     * Hence the difference between the sum of the squares of the first ten natural numbers and the
     * square of the sum is 3025 − 385 = 2640.
     *
     * Find the difference between the sum of the squares of the first one hundred natural numbers
     * and the square of the sum.
     */
    @Test
    fun `Problem 6`() {
        val sumOfSquares = (1..100L).sumOf { it.squared() }
        val squareOfSums = (1..100L).sum().squared()
        val result = squareOfSums - sumOfSquares

        assertThat(result).isEqualTo(25164150L)
    }

    /**
     * Problem 7
     *
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime
     * is 13.
     *
     * What is the 10,001st prime number?
     */
    @Test
    fun `Problem 7`() {
        val result = primeSequence()
            .take(10001)
            .last()

        assertThat(result).isEqualTo(104743L)
    }
}
