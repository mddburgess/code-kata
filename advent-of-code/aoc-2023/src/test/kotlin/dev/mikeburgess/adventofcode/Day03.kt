package dev.mikeburgess.adventofcode

import dev.mikeburgess.adventofcode.day03.PartNumber
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class Day03 {

    private val input = readInput(3)
    private val schematic = LinkedHashMap<Pair<Int, Int>, PartNumber>()

    @BeforeTest
    fun readSchematic() {
        input.forEachIndexed { row, s ->
            var part = PartNumber()
            s.forEachIndexed { col, c ->
                if (c in '0'..'9') {
                    part.append(c)
                    schematic[row to col] = part
                } else {
                    part = PartNumber()
                }
            }
        }
    }

    @Test
    fun part1() {
        input.forEachIndexed { row, s ->
            s.forEachIndexed { col, c ->
                if (c != '.' && c !in '0'..'9') {
                    schematic[row - 1 to col - 1]?.included = true
                    schematic[row - 1 to col]?.included = true
                    schematic[row - 1 to col + 1]?.included = true
                    schematic[row to col - 1]?.included = true
                    schematic[row to col + 1]?.included = true
                    schematic[row + 1 to col - 1]?.included = true
                    schematic[row + 1 to col]?.included = true
                    schematic[row + 1 to col + 1]?.included = true
                }
            }
        }

        val result = schematic.filter { it.value.included }
            .values
            .distinct()
            .sumOf { it.value }
        assertEquals(538046, result)
    }

    @Test
    fun part2() {
        var result = 0
        input.forEachIndexed { row, s ->
            s.forEachIndexed { col, c ->
                if (c == '*') {
                    val parts = arrayOf(
                        schematic[row - 1 to col - 1],
                        schematic[row - 1 to col],
                        schematic[row - 1 to col + 1],
                        schematic[row to col - 1],
                        schematic[row to col + 1],
                        schematic[row + 1 to col - 1],
                        schematic[row + 1 to col],
                        schematic[row + 1 to col + 1]
                    ).filterNotNull().distinct()
                    if (parts.size == 2) {
                        result += parts[0].value * parts[1].value
                    }
                }
            }
        }
        assertEquals(81709807, result)
    }
}
