package dev.mikeburgess.adventofcode.day02

import kotlin.math.max

class Game(
    input: String
) {

    val id: Int
    private val draws: List<Draw>

    init {
        val tokens = input.split(": ")
        id = tokens[0].split(" ")[1].toInt()
        draws = tokens[1].split("; ").map { Draw(it) }
    }

    fun isValidWith(count: Int, colour: String) =
        draws.all { it.isValidWith(count, colour) }

    fun power(): Int {
        val minimumSet = HashMap<String, Int>()
        draws.map { it.balls }
            .flatMap { it.entries }
            .forEach { minimumSet[it.key] = max(minimumSet[it.key] ?: 0, it.value)}
        return minimumSet.values.reduce { acc, i -> acc * i }
    }

}
