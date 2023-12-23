package dev.mikeburgess.adventofcode.day02

class Draw(input: String) {

    private val balls: MutableMap<String, Int> = HashMap()

    init {
        input.split(", ")
            .map { it.split(" ") }
            .forEach { balls[it[1]] = it[0].toInt() }
    }

    fun isValidWith(count: Int, colour: String): Boolean =
        (balls[colour] ?: 0) <= count

    override fun toString(): String =
        balls.toString()
}
