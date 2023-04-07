package algorithms.islands

/*
Given a 2D grid consists of 0s (land) and 1s (water).
An island is a maximal 4-directionally connected group of 0s and
a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Example:
Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2

Explanation:
Islands in gray are closed because they are completely surrounded by water (group of 1s).
*/

fun main() {
    val sea1 = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 1, 0),
        intArrayOf(1, 0, 1, 0, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 1, 0),
    )

    val sea2 = arrayOf(
        intArrayOf(0, 0, 1, 1, 0, 1, 0, 0, 1, 0),
        intArrayOf(1, 1, 0, 1, 1, 0, 1, 1, 1, 0),
        intArrayOf(1, 0, 1, 1, 1, 0, 0, 1, 1, 0),
        intArrayOf(0, 1, 1, 0, 0, 0, 0, 1, 0, 1),
        intArrayOf(0, 0, 0, 0, 0, 0, 1, 1, 1, 0),
        intArrayOf(0, 1, 0, 1, 0, 1, 0, 1, 1, 1),
        intArrayOf(1, 0, 1, 0, 1, 1, 0, 0, 0, 1),
        intArrayOf(1, 1, 1, 1, 1, 1, 0, 0, 0, 0),
        intArrayOf(1, 1, 1, 0, 0, 1, 0, 1, 0, 1),
        intArrayOf(1, 1, 1, 0, 1, 1, 0, 1, 1, 0),
    )

    closedIsland(sea1)
    closedIsland(sea2)
}

fun closedIsland(grid: Array<IntArray>): Int {
    var result = 0
    for (i in 1 until grid.size - 1) {
        for (j in 1 until grid[0].size - 1) {
            if (grid[i][j] == 0) {
                if (isClosedIsland(grid, i, j)) {
                    result++
                }
            }
        }
    }

    println("Result is $result")
    return result
}

fun isClosedIsland(grid: Array<IntArray>, r: Int, c: Int): Boolean {
    var result = true
    if (grid[r][c] == 0) {
        grid[r][c] = 2

        if (r == 0 || c == 0 || r == grid.size - 1 || c == grid[0].size - 1) {
            return false
        }

        result = isClosedIsland(grid, r - 1, c)
            .and(isClosedIsland(grid, r, c - 1))
            .and(isClosedIsland(grid, r + 1, c))
            .and(isClosedIsland(grid, r, c + 1))
    }
    return result
}