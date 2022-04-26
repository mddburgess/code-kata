package dev.mikeburgess.euler.extensions

fun Triple<Long, Long, Long>.isPythagorean() =
    first * first + second * second == third * third

fun Triple<Long, Long, Long>.product() =
    first * second * third
