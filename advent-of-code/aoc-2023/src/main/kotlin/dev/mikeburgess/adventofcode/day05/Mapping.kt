package dev.mikeburgess.adventofcode.day05

class Mapping(
    input: String
) {
    val destStart: Long
    val srcStart: Long
    val range: Long

    init {
        val tokens = input.split(" ").map { it.toLong() }
        destStart = tokens[0]
        srcStart = tokens[1]
        range = tokens[2]
    }

    fun matches(candidate: Long) = candidate in srcStart until srcStart + range

    fun convert(src: Long) = src - srcStart + destStart

    override fun toString(): String {
        return "$destStart $srcStart $range"
    }
}
