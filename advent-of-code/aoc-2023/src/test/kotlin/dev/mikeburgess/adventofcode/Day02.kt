package dev.mikeburgess.adventofcode

import dev.mikeburgess.adventofcode.day02.Game
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02 {

    @Test
    fun part1() {
        val input = readInput(2)
        val result = input.map { Game(it) }
            .filter { it.isValidWith(12, "red") }
            .filter { it.isValidWith(13, "green") }
            .filter { it.isValidWith(14, "blue") }
            .sumOf { it.id }
        assertEquals(3099, result)
    }
}
