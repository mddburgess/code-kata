package dev.mikeburgess.adventofcode

import java.nio.file.Path
import kotlin.io.path.readLines

fun readInput(day: Int): List<String> =
    Path.of("src", "test", "resources", "input", "day${day}.txt")
        .readLines()
        .filter { it.isNotEmpty() }
