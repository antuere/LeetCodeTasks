package algorithms

/*
Given an integer array nums,
rotate the array to the right by k steps,
where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/


fun main() {
    val result1 = rotate(nums = intArrayOf(1, 2, 3, 4, 5, 6, 7), k = 3)
    val result2 = rotate(nums = intArrayOf(1), k = 3)
    val result3 = rotate(nums = intArrayOf(1, 2), k = 3)
    val result4 = rotate(nums = intArrayOf(1, 2, 3, 4, 5, 6), k = 11)
    val result5 = rotate(nums = intArrayOf(1, 2), k = 5)


    println("Result1 is ${result1.toList()}")
    println("Result2 is ${result2.toList()}")
    println("Result3 is ${result3.toList()}")
    println("Result4 is ${result4.toList()}")
    println("Result5 is ${result5.toList()}")
}


fun rotate(nums: IntArray, k: Int): IntArray {
    if (nums.size == 1) {
        return nums
    }

    val tempArray = nums.copyOf()

    nums.forEachIndexed { index, _ ->
        if (index + k > nums.size - 1) {
            var resultIndex = (k - (nums.size - 1 - index)) - 1

            while (resultIndex > nums.size - 1) {
                resultIndex -= nums.size

                if (resultIndex < 0) {
                    resultIndex = 0
                }
            }

            nums[resultIndex] = tempArray[index]
        } else {
            nums[index + k] = tempArray[index]
        }
    }
    return nums
}
