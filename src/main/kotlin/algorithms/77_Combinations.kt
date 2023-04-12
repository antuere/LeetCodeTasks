package algorithms

/*
Given two integers n and k,
return all possible combinations of k numbers chosen
from the range [1, n].

You may return the answer in any order.

Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
*/

fun main() {
    val result = combine(4, 3)

    result.forEach{
        println(it)
    }
}

fun combine(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    findCombinations(1, k, n, result, mutableListOf())
    return result

}

fun findCombinations(
    start: Int,
    k: Int,
    n: Int,
    combinations: MutableList<List<Int>>,
    combination: MutableList<Int>,
) {
    if (combination.size == k) {
        combinations.add(ArrayList(combination))
        return
    }

    for (i in start..n) {
        combination.add(i)
        if (i + 1 <= n + 1) {
            findCombinations(i + 1, k, n, combinations, combination)
        }
        combination.removeAt(combination.lastIndex)
    }
}