package algorithms

import java.util.*

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange
that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1.
*/

fun main() {
    val matrix1 = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1),
    )

    println("Result is ${orangesRotting(matrix1)}")
}

fun orangesRotting(grid: Array<IntArray>): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val freshToRotter = mutableMapOf<Pair<Int, Int>, Int>()
    var freshOranges = 0

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 2) {
                queue.add(Pair(i, j))
            }
            if (grid[i][j] == 1) {
                freshOranges++
            }
        }
    }

    if (queue.isEmpty()) {
        return -1
    }

    if (freshOranges == 0) {
        return 0
    }

    while (queue.isNotEmpty()) {
        val cell = queue.poll()
        val r = cell.first
        val c = cell.second

        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
            val prevDist = freshToRotter.getOrDefault(Pair(r - 1, c), 10000)
            val currentDist = freshToRotter[Pair(r, c)] ?: 0
            if (prevDist > currentDist + 1) {
                queue.add(Pair(r - 1, c))
                freshToRotter[Pair(r - 1, c)] = currentDist + 1
            }
        }
        if (r + 1 < grid.size && grid[r + 1][c] == 1) {
            val prevDist = freshToRotter.getOrDefault(Pair(r + 1, c), 10000)
            val currentDist = freshToRotter[Pair(r, c)] ?: 0
            if (prevDist > currentDist + 1) {
                queue.add(Pair(r + 1, c))
                freshToRotter[Pair(r + 1, c)] = currentDist + 1
            }
        }
        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
            val prevDist = freshToRotter.getOrDefault(Pair(r, c - 1), 10000)
            val currentDist = freshToRotter[Pair(r, c)] ?: 0
            if (prevDist > currentDist + 1) {
                queue.add(Pair(r, c - 1))
                freshToRotter[Pair(r, c - 1)] = currentDist + 1
            }
        }
        if (c + 1 < grid[0].size && grid[r][c + 1] == 1) {
            val prevDist = freshToRotter.getOrDefault(Pair(r, c + 1), 10000)
            val currentDist = freshToRotter[Pair(r, c)] ?: 0
            if (prevDist > currentDist + 1) {
                queue.add(Pair(r, c + 1))
                freshToRotter[Pair(r, c + 1)] = currentDist + 1
            }
        }
    }

    if (freshOranges > freshToRotter.size) {
        return -1
    }

    return freshToRotter.maxBy { it.value }.value
}
