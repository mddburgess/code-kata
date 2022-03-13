package dev.mikeburgess.euler.sequences

import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*

@Target(CLASS, FUNCTION)
@Retention(SOURCE)
annotation class OEIS(
    val sequence: String
)
