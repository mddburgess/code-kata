package dev.mikeburgess.adventofcode.day02

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

    override fun toString(): String =
        "Game $id: $draws"
}
