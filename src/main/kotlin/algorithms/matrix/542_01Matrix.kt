package algorithms.matrix

import java.util.LinkedList
import java.util.Queue

/*
Given an m x n binary matrix mat,
return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
*/

fun main() {
    val matrix1 = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
    )
    val matrix2 = arrayOf(
            intArrayOf(1, 0, 1, 1, 0, 0, 1, 0, 0, 1),
            intArrayOf(0, 1, 1, 0, 1, 0, 1, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 1, 0, 0, 1, 0, 0),
            intArrayOf(1, 0, 1, 0, 1, 1, 1, 1, 1, 1),
            intArrayOf(0, 1, 0, 1, 1, 0, 0, 0, 0, 1),
            intArrayOf(0, 0, 1, 0, 1, 1, 1, 0, 1, 0),
            intArrayOf(0, 1, 0, 1, 0, 1, 0, 0, 1, 1),
            intArrayOf(1, 0, 0, 0, 1, 1, 1, 1, 0, 1),
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 0, 1, 0),
            intArrayOf(1, 1, 1, 1, 0, 1, 0, 0, 1, 1),
    )
    updateMatrix(matrix2)
}

// This best solution
fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val distances = Array(mat.size) { IntArray(mat[0].size) { 100000 } }

    for (i in mat.indices) {
        for (j in mat[0].indices) {
            if (mat[i][j] == 0) {
                distances[i][j] = 0
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val cell = queue.poll()
        val r = cell.first
        val c = cell.second

        if (r - 1 >= 0 && distances[r - 1][c] > distances[r][c] + 1) {
            queue.add(Pair(r - 1, c))
            distances[r - 1][c] = distances[r][c] + 1
        }
        if (r + 1 < mat.size && distances[r + 1][c] > distances[r][c] + 1) {
            queue.add(Pair(r + 1, c))
            distances[r + 1][c] = distances[r][c] + 1
        }
        if (c - 1 >= 0 && distances[r][c - 1] > distances[r][c] + 1) {
            queue.add(Pair(r, c - 1))
            distances[r][c - 1] = distances[r][c] + 1
        }
        if (c + 1 < mat[0].size && distances[r][c + 1] > distances[r][c] + 1) {
            queue.add(Pair(r, c + 1))
            distances[r][c + 1] = distances[r][c] + 1
        }
    }
    return distances
}


// Very long solution
fun updateMatrixLong(mat: Array<IntArray>): Array<IntArray> {
    for (i in mat.indices) {
        for (j in mat[0].indices) {
            if (mat[i][j] == 1) {
                mat[i][j] = foundNearestZero(mat, i, j)
            }
        }
    }
    mat.toList().forEach {
        println("Result is ${it.toList()}")
    }
    return mat
}


// Very long solution
fun foundNearestZero(mat: Array<IntArray>, sr: Int, sc: Int): Int {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val distances = Array(mat.size) { IntArray(mat[0].size) { 10000 } }

    queue.add(Pair(sr, sc))
    distances[sr][sc] = 0

    while (queue.isNotEmpty()) {
        val cell = queue.poll()
        val r = cell.first
        val c = cell.second

        if (mat[r][c] == 0) {
            return distances[r][c]
        }

        if (r - 1 >= 0 && distances[r - 1][c] > distances[r][c] + 1) {
            queue.add(Pair(r - 1, c))
            distances[r - 1][c] = distances[r][c] + 1
        }
        if (r + 1 < mat.size && distances[r + 1][c] > distances[r][c] + 1) {
            queue.add(Pair(r + 1, c))
            distances[r + 1][c] = distances[r][c] + 1
        }
        if (c - 1 >= 0 && distances[r][c - 1] > distances[r][c] + 1) {
            queue.add(Pair(r, c - 1))
            distances[r][c - 1] = distances[r][c] + 1
        }
        if (c + 1 < mat[0].size && distances[r][c + 1] > distances[r][c] + 1) {
            queue.add(Pair(r, c + 1))
            distances[r][c + 1] = distances[r][c] + 1
        }
    }
    return -1
}
