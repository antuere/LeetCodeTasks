package algorithms

/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
*/

fun main() {
    val result = binarySearch(nums = intArrayOf(-1, 0, 3, 5, 9, 12), target = 5)
    println("Result is $result")
}

fun binarySearch(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1

    while (low <= high) {
        val mid = (low + high) / 2
        val value = nums[mid]

        if (value == target) {
            return mid
        }

        if (value < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    return -1
}