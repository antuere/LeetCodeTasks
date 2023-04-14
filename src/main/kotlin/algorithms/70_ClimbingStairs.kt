package algorithms

/*
You are climbing a staircase.
It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?



Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

fun main() {
    println("Result is ${climbStairs(3)}")
    println("Result is ${climbStairs(2)}")
    println("Result is ${climbStairs(4)}")
    println("Result is ${climbStairs(1)}")
    println("Result is ${climbStairs(44)}")
}

fun climbStairs(n: Int): Int {
    val memo = IntArray(n + 1)
    return findSteps(n, 0, memo)
}

fun findSteps(target: Int, current: Int, memo: IntArray): Int {
    if (current > target) {
        return 0
    }

    if (memo[current] != 0) {
        return memo[current]
    }

    if (current == target) {
        return 1
    }
    memo[current] += findSteps(target, current + 1, memo)
    memo[current] += findSteps(target, current + 2, memo)

    return memo[current]
}
