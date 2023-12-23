package dev.mikeburgess.adventofcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day01 {

    @Test
    fun part1() {
        val input = readInput(1)
        val result = input.sumOf { getIntValue(it) }
        assertEquals(56042, result)
    }

    fun getIntValue(str: String): Int {
        val strValue = str.replace(Regex("[a-z]"), "")
        return (strValue[0] - '0') * 10 + (strValue[strValue.length - 1] - '0')
    }

    @Test
    fun part2() {
        val input = readInput(1)
        val result = input.sumOf { getAlphaValue(it) }
        assertEquals(55358, result)
    }

    fun getAlphaValue(str: String): Int = getIntValue(str
        .replace("one", "o1e")
        .replace("two", "t2o")
        .replace("three", "t3e")
        .replace("four", "f4r")
        .replace("five", "f5e")
        .replace("six", "s6x")
        .replace("seven", "s7n")
        .replace("eight", "e8t")
        .replace("nine", "n9e")
    )
}
