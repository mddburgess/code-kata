package dev.mikeburgess.euler.extensions

fun Long.isEven() = this % 2 == 0L

fun Long.isPalindrome(base: Long = 10L): Boolean {
    var temp = this
    var reverse = 0L

    while (temp > 0) {
        reverse = reverse * base + (temp % base)
        temp /= base
    }

    return this == reverse
}

fun Long.squared() = this * this
