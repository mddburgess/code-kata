package dev.mikeburgess.adventofcode

import dev.mikeburgess.adventofcode.day04.Scratchcard
import kotlin.test.Test
import kotlin.test.assertEquals

class Day04 {

    @Test
    fun part1() {
        val input = readInput(4)
        val result = input.map { Scratchcard(it) }.sumOf { it.value() }
        assertEquals(21105, result)
    }

    @Test
    fun part2() {
        val input = readInput(4)
        val scratchcards = input.map { Scratchcard(it) }
        scratchcards.forEachIndexed { index, scratchcard ->
            for (offset in 1..scratchcard.matches()) {
                scratchcards[index + offset].count += scratchcards[index].count
            }
        }
        val result = scratchcards.sumOf { it.count }
        assertEquals(5329815, result)
    }
}
