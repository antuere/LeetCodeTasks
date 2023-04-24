package algorithms

import java.util.PriorityQueue

/*
You are given an array of integers stones
where stones[i] is the weight of the ith stone.

We are playing a game with the stones.
On each turn, we choose the heaviest two stones and smash them together.
Suppose the heaviest two stones have weights x and y with x <= y.
The result of this smash is:
If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed,
and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone.
If there are no stones left, return 0.
*/

fun main() {
    val result = lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1))
    val result1 = lastStoneWeight(intArrayOf(2))
    println("Result is $result")
    println("Result1 is $result1")
}

fun lastStoneWeight(stones: IntArray): Int {
    val sortedStones = PriorityQueue { el1: Int, el2: Int -> el2 - el1 }
    stones.forEach {
        sortedStones.add(it)
    }

    while (sortedStones.size > 1) {
        val first = sortedStones.poll()
        val second = sortedStones.poll()

        if (first - second > 0) {
            val newStone = first - second
            sortedStones.add(newStone)
        }
    }

    return sortedStones.peek() ?: 0
}
