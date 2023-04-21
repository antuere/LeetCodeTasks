package algorithms

import kotlin.math.min

fun main() {
}

fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
    val memo = Array(101) { Array(101) { IntArray(101) } }

    for (i in 0..n) {
        memo[group.size][i][minProfit] = 1
    }

    for (index in profit.lastIndex downTo 0) {
        for (peopleCount in 0..n) {
            for (cProfit in 0..minProfit) {
                memo[index][peopleCount][cProfit] = memo[index + 1][peopleCount][cProfit]

                if (peopleCount + group[index] <= n) {
                    memo[index][peopleCount][cProfit] =
                        (memo[index][peopleCount][cProfit] + memo[index + 1][peopleCount + group[index]][min(
                            minProfit,
                            cProfit + profit[index]
                        )]).mod()
                }

            }
        }
    }
    return memo[0][0][0]

}

fun Int.mod(): Int {
    return this % 1000000007
}