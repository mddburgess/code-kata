package dev.mikeburgess.adventofcode

import dev.mikeburgess.adventofcode.day05.Almanac
import kotlin.test.Test
import kotlin.test.assertEquals

class Day05 {

    @Test
    fun part1() {
        val almanac = Almanac(readInput(5))
        val result = almanac.closestLocation()
        assertEquals(107430936, result)
    }
}
