package algorithms.matrix

/*
You are given an m x n binary matrix grid,
where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent
(4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which
we cannot walk off the boundary of the grid in any number of moves.

Example 1:

Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s,
and one 1 that is not enclosed because its on the boundary.
*/

fun main() {
    val sea1 = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0),
    )
    numEnclaves(sea1)
}

fun numEnclaves(grid: Array<IntArray>): Int {
    var numEnclaves = 0
    for (i in 1 until grid.size - 1) {
        for (j in 1 until grid[0].size - 1) {
            if (grid[i][j] == 1) {
                val tempResult = countClosedIslandsSize(grid, i, j)
                if (tempResult > 0) {
                    numEnclaves += tempResult
                }
            }
        }
    }

    println("Result is $numEnclaves")
    return numEnclaves
}

fun countClosedIslandsSize(grid: Array<IntArray>, r: Int, c: Int): Int {
    var result = 0
    if (grid[r][c] == 1) {
        grid[r][c] = 2
        result++

        if (r == 0 || c == 0 || r == grid.size - 1 || c == grid[0].size - 1) {
            return -1000000
        }

        val topResult = countClosedIslandsSize(grid, r - 1, c)
        val leftResult = countClosedIslandsSize(grid, r, c - 1)
        val botResult = countClosedIslandsSize(grid, r + 1, c)
        val rightResult = countClosedIslandsSize(grid, r, c + 1)
        result += topResult + leftResult + botResult + rightResult
    }
    return result

}