package algorithms

/*Given a triangle array,
return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below.
More formally, if you are on index i on the current row,
you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
2
3 4
6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
*/

fun main() {
// Its works
}

fun minimumTotal(triangle: List<List<Int>>): Int {
    val memo = Array(triangle.size) {
        IntArray(triangle.last().size) {
            -11
        }
    }
    return recursive(triangle, 0, 0, memo)
}

fun recursive(triangle: List<List<Int>>, row: Int, index: Int, memo: Array<IntArray>): Int {
    if (row >= triangle.size) {
        return 0
    }

    if (memo[row][index] != -11) {
        return memo[row][index]
    }
    val currentVal = triangle[row][index]
    val leftVal = recursive(triangle, row + 1, index, memo) + currentVal
    val rightVal = recursive(triangle, row + 1, index + 1, memo) + currentVal
    memo[row][index] = Math.min(leftVal, rightVal)

    return memo[row][index]
}