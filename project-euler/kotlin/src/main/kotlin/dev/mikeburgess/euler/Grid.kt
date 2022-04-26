package dev.mikeburgess.euler

class Grid(
    private val width: Int,
    private val height: Int,
    private vararg val values: Long
) {
    operator fun get(row: Int, col: Int) = when {
        row < 0 || row >= height -> 0L
        col < 0 || col >= width -> 0L
        else -> values[row * height + col]
    }

    fun mapIndexed(fn: (row: Int, col: Int, value: Long) -> Long): Grid {
        val newValues = values.mapIndexed { i, v -> fn(i / width, i % width, v) }.toLongArray()
        return Grid(width, height, *newValues)
    }

    fun max() =
        values.maxOf { it }
}
