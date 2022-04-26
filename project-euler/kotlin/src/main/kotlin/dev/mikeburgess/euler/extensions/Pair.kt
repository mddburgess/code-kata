package dev.mikeburgess.euler.extensions

infix fun <A, B, C> Pair<A, B>.to(c: C) =
    Triple(this.first, this.second, c)
