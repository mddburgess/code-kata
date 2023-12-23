package dev.mikeburgess.adventofcode.day03

class PartNumber {

    var value = 0
    var included = false

    fun append(digit: Char) {
        value = value * 10 + (digit - '0')
    }
}
