package dev.mikeburgess.euler.extensions

fun Int.isAbundant() =
    properDivisors.sum() > this

val Int.properDivisors
    get() = (1..this / 2).filter { this % it == 0 }

fun Int.toWordString() = when {
    this > 1000 -> TODO("Not implemented for numbers over 1000")
    this == 1000 -> "one thousand"
    this >= 100 -> hundreds(this)
    this > 0 -> tensAndOnes(this)
    else -> throw IllegalArgumentException("Number must be greater than zero")
}

private fun hundreds(number: Int) = when {
    number % 100 == 0 -> "${ones(number / 100)} hundred"
    else -> "${ones(number / 100)} hundred and ${tensAndOnes(number % 100)}"
}

private fun tensAndOnes(number: Int) = when {
    number >= 20 -> twentiesAndOnes(number)
    number >= 10 -> tens(number)
    number > 0 -> ones(number)
    else -> throw IllegalStateException()
}

private fun twentiesAndOnes(number: Int) = when {
    number % 10 == 0 -> twenties(number)
    else -> "${twenties(number)}-${ones(number)}"
}

private fun twenties(number: Int) = when (number / 10) {
    2 -> "twenty"
    3 -> "thirty"
    4 -> "forty"
    5 -> "fifty"
    6 -> "sixty"
    7 -> "seventy"
    8 -> "eighty"
    9 -> "ninety"
    else -> throw IllegalStateException()
}

private fun tens(number: Int) = when (number % 100) {
    10 -> "ten"
    11 -> "eleven"
    12 -> "twelve"
    13 -> "thirteen"
    14 -> "fourteen"
    15 -> "fifteen"
    16 -> "sixteen"
    17 -> "seventeen"
    18 -> "eighteen"
    19 -> "nineteen"
    else -> throw IllegalStateException()
}

private fun ones(number: Int) = when (number % 10) {
    1 -> "one"
    2 -> "two"
    3 -> "three"
    4 -> "four"
    5 -> "five"
    6 -> "six"
    7 -> "seven"
    8 -> "eight"
    9 -> "nine"
    else -> throw IllegalStateException()
}
