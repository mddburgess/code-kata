package dev.mikeburgess.euler

import java.nio.file.Path

fun getResourceAsLines(resource: String) =
    Path.of("src", "test", "resources", resource)
        .toFile()
        .readLines()
        .filter { it.isNotBlank() }

fun getResourceAsInts(resource: String) =
    getResourceAsLines(resource)
        .map { it.split(' ').map(String::toInt) }
