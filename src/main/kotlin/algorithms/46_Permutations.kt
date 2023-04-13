package algorithms

/*
Given an array nums of distinct integers,
return all the possible permutations.
You can return the answer in any order.



Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
*/

fun main() {
    val result = permute(intArrayOf(1, 2, 3))

    result.forEach {
        println(it)
    }
}

fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    findAllPermutations(0, nums, result)
    return result
}

fun findAllPermutations(
    start: Int,
    array: IntArray,
    combinations: MutableList<List<Int>>,
) {
    if (start >= array.size) {
        combinations.add((array.toList()))
        return
    }

    for (i in start until array.size) {
        val temp = array[i]
        array[i] = array[start]
        array[start] = temp

        findAllPermutations(start + 1, array, combinations)

        val temp2 = array[i]
        array[i] = array[start]
        array[start] = temp2
    }
}