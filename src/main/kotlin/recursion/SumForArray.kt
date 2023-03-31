package recursion

fun main() {
    val resultSum = sum(intArrayOf(1, 0, 3, 5, 9, 12))
    println("Result sum is $resultSum")
}


fun sum(nums: IntArray): Int {
    if (nums.size == 1) {
        return nums[0]
    }
    return nums[0] + sum(nums = nums.copyOfRange(1, nums.size))
}