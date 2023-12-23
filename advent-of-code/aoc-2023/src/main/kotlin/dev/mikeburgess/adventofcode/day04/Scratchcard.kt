package dev.mikeburgess.adventofcode.day04

import kotlin.math.pow

class Scratchcard(
    input: String
) {
    val id: Int
    val winningNumbers: Set<Int>
    val yourNumbers: Set<Int>
    var count = 1

    init {
        val components = input.split(Regex("[:|]"))
        id = components[0].split(Regex("\\s+"))[1].toInt()
        winningNumbers = components[1].split(Regex("\\s+"))
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toSet()
        yourNumbers = components[2].split(Regex("\\s+"))
            .filter { it.isNotEmpty() }
            .map { it.toInt() }
            .toSet()
    }

    fun matches() = yourNumbers.filter { winningNumbers.contains(it) }.size

    fun value(): Int {
        val matches = matches()
        return if (matches == 0) 0 else (2.0).pow(matches - 1).toInt()
    }
}
