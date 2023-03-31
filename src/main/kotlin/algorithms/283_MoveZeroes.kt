package algorithms

/*
Given an integer array nums,
move all 0's to the end of it while
maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
*/

fun main() {
    moveZeroes(intArrayOf(1, 0, 0))
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
    moveZeroes(intArrayOf(0))
    moveZeroes(intArrayOf(1, 0))
}


fun moveZeroes(nums: IntArray) {
    var iterator = 0
    var noneZeroIndex = 0

    while (noneZeroIndex < nums.size) {
        if (nums[iterator] == 0 && nums[noneZeroIndex] == 0) {
            noneZeroIndex++
            continue
        }

        if (nums[iterator] == 0 && nums[noneZeroIndex] != 0) {
            nums[iterator] = nums[noneZeroIndex]
            nums[noneZeroIndex] = 0
        }
        iterator++
        noneZeroIndex++
    }

    println("Result is ${nums.toList()}")
}