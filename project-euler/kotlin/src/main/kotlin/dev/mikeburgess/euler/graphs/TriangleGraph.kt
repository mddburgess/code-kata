package dev.mikeburgess.euler.graphs

import kotlin.math.max

class TriangleGraph(values: List<List<Int>>) {

    private val graph: List<List<Node>> =
        values.map { it.map { number -> Node(number) } }

    init {
        graph.forEachIndexed { row, list ->
            list.forEachIndexed { col, node ->
                if (row + 1 < graph.size) {
                    node.left = graph[row + 1][col]
                    node.right = graph[row + 1][col + 1]
                }
            }
        }
    }

    fun maxSum() =
        graph[0][0].maxSum()

    private class Node(val initialValue: Int) {

        var calculatedValue: Int? = null
        var left: Node? = null
        var right: Node? = null

        fun maxSum() = when {
            calculatedValue != null -> calculatedValue
            else -> calculateValue().also { calculatedValue = it }
        }

        fun calculateValue(): Int =
            max(initialValue + (left?.maxSum() ?: 0), initialValue + (right?.maxSum() ?: 0))
    }
}
