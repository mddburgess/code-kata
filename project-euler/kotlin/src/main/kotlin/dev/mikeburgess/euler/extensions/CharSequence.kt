package dev.mikeburgess.euler.extensions

fun CharSequence.countLetters() =
    this.count { it in 'a'..'z' }
