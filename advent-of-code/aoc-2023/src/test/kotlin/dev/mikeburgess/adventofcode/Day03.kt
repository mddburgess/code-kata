package dev.mikeburgess.adventofcode

import dev.mikeburgess.adventofcode.day03.PartNumber
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03 {

    @Test
    fun part1() {
        val input = readInput(3)
        val grid = LinkedHashMap<Pair<Int, Int>, PartNumber>()
        input.forEachIndexed { row, s ->
            var part = PartNumber()
            s.forEachIndexed { col, c ->
                if (c in '0'..'9') {
                    part.append(c)
                    grid[row to col] = part
                } else {
                    part = PartNumber()
                }
            }
        }

        input.forEachIndexed { row, s ->
            s.forEachIndexed { col, c ->
                if (c != '.' && c !in '0'..'9') {
                    grid[row - 1 to col - 1]?.included = true
                    grid[row - 1 to col]?.included = true
                    grid[row - 1 to col + 1]?.included = true
                    grid[row to col - 1]?.included = true
                    grid[row to col + 1]?.included = true
                    grid[row + 1 to col - 1]?.included = true
                    grid[row + 1 to col]?.included = true
                    grid[row + 1 to col + 1]?.included = true
                }
            }
        }

        val result = grid.filter { it.value.included }
            .values
            .distinct()
            .sumOf { it.value }
        assertEquals(538046, result)
    }
}
