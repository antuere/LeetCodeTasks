package algorithms

/*
Given a sorted array of distinct integers and a target value,
return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [1,3,5,6], target = 5
Output: 2
*/

fun main() {
    val result = searchInsert(nums = intArrayOf(1, 3, 5, 6), target = 5)
    println("Result is $result")
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var result = nums.size

    var start = 0
    var middle = nums.size / 2
    var end = nums.size - 1

    while (end != middle && middle >= 0) {
        if (nums[middle] < target) {
            start = middle
            middle = (end - start) / 2 + start + 1
        } else {
            end = middle
            middle = (end - start) / 2 + start - 1
        }
    }

    for (i in start..end) {
        if (i == 0 && nums[i] > target) {
            result = 0
            break
        }
        if (nums[i] == target) {
            result = i
            break
        }
        if (nums[i] > target) {
            result = if (i == end || i == 1 || i == end - 1) i else i - 1
            break
        }
    }

    return result
}