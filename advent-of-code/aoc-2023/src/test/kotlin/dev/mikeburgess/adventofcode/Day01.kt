package dev.mikeburgess.adventofcode

import org.junit.jupiter.api.Test

class Day01 {

    @Test
    fun part1() {
        val input = this.javaClass.classLoader.getResource("input/day01.txt")!!.readText()
        println(input.lines().sumOf { getIntValue(it) })
    }

    fun getIntValue(str: String): Int {
        val strValue = str.replace(Regex("[a-z]"), "")
        return if (strValue == "") {
            0
        } else {
            (strValue[0] - '0') * 10 + (strValue[strValue.length - 1] - '0')
        }
    }

    @Test
    fun part2() {
        val input = this.javaClass.classLoader.getResource("input/day01.txt")!!.readText()
        println(input.lines().sumOf { getAlphaValue(it) })
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
