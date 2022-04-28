package dev.mikeburgess.euler.extensions

val String.wordScore: Int
    get() = sumOf { it - '@' }
