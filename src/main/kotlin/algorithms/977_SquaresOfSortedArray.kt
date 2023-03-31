package algorithms

/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in non-decreasing order.

Example:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
*/


fun main() {
    val result = sortedSquares(nums = intArrayOf(-4, -1, 0, 3, 10))
    println("Result is ${result.toList()}")
}

fun sortedSquares(nums: IntArray): IntArray {
    for(i in nums.indices){
        val highIndex = nums.size - i - 1
        if(highIndex < i){
            break
        }
        if(highIndex == i){
            nums[i] = nums[i] * nums[i]
            break
        }

        val lowValue = nums[i]
        val highValue = nums[highIndex]

        nums[i] = lowValue * lowValue
        nums[highIndex] = highValue * highValue

    }

    return nums.sortedArray()
}
