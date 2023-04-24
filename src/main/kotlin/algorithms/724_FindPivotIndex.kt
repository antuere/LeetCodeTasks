package algorithms

/*
Given an array of integers nums,
calculate the pivot index of this array.

The pivot index is the index where
the sum of all the numbers strictly to the left of the
index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array,
then the left sum is 0 because there are no elements to the left.
This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists,
return -1.
*/

fun main() {
    val result = pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6))
    println("Result is $result")
}

fun pivotIndex(nums: IntArray): Int {
    val sumLeft = IntArray(nums.size)
    val sumRight = IntArray(nums.size)


    for (i in nums.indices) {
        if (i != 0) {
            sumLeft[i] = nums.copyOfRange(0, i).sum()
        }
        if (i != nums.lastIndex) {
            sumRight[i] = nums.copyOfRange(i + 1, nums.size).sum()
        }

        if (sumLeft[i] == sumRight[i]) {
            return i
        }
    }

    return -1
}
