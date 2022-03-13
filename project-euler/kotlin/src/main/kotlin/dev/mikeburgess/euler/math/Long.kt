package dev.mikeburgess.euler.math

fun lcm(x: Long, y: Long): Long = x * y / gcd(x, y)

fun gcd(x: Long, y: Long): Long = when (y) {
    0L -> x
    else -> gcd(y, x % y)
}
