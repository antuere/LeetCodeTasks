package algorithms

/*
You are given an m x n binary matrix grid.
An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid.
If there is no island, return 0.

Input: grid =[
[0,0,1,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,1,1,0,1,0,0,0,0,0,0,0,0],
[0,1,0,0,1,1,0,0,1,0,1,0,0],
[0,1,0,0,1,1,0,0,1,1,1,0,0],
[0,0,0,0,0,0,0,0,0,0,1,0,0],
[0,0,0,0,0,0,0,1,1,1,0,0,0],
[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
*/

fun main() {
    val sea = arrayOf(
        intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
        intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
    )

    maxAreaOfIsland(grid = sea)
}

fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var result = 0

    val m = grid.size
    val n = grid[0].size

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                val currentResult = dfs(grid, i, j)
                result = Math.max(currentResult, result)
            }
        }
    }

    println("Result is $result")
    return result
}

fun dfs(grid: Array<IntArray>, r: Int, c: Int): Int {
    var islandSize = 0
    if (grid[r][c] == 1) {
        islandSize++
        grid[r][c] = 0

        if (r >= 1) islandSize += dfs(grid, r - 1, c)
        if (r + 1 < grid.size) islandSize += dfs(grid, r + 1, c)
        if (c >= 1) islandSize += dfs(grid, r, c - 1)
        if (c + 1 < grid[0].size) islandSize += dfs(grid, r, c + 1)
    }
    return islandSize
}
