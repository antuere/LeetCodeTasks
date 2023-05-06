package algorithms

/*
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that
the sum of the minimum and maximum element on it is less or equal to target.
Since the answer may be too large,
return it modulo 109 + 7.
*/

fun main() {
    println("Result is ${numSubseq(intArrayOf(2, 3, 3, 4, 6, 7), 12)}")
    println("Result is ${numSubseq(intArrayOf(3, 3, 6, 8), 10)}")
    println("Result is ${numSubseq(intArrayOf(3, 5, 6, 7), 9)}")
    println("Result is ${numSubseq(intArrayOf(14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14), 22)}")
}

fun numSubseq(nums: IntArray, target: Int): Int {
    nums.sort()
    var numSubseq = 0
    var max = nums.lastIndex
    var min = 0
    val powerValues = IntArray(size = nums.size)

    powerValues[0] = 1
    for (i in 1 until nums.size) {
        powerValues[i] = (powerValues[i - 1] * 2) % 1_000_000_007
    }
    while (min <= max) {
        if (nums[min] + nums[max] > target) {
            max--
            continue
        }
        numSubseq += powerValues[max - min]
        numSubseq %= 1_000_000_007
        min++
    }

    return numSubseq
}

