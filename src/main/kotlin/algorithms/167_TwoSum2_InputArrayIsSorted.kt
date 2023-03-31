package algorithms

/*Given a 1-indexed array of integers numbers
that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2]
where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2,
added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution.
You may not use the same element twice.

Your solution must use only constant extra space.

Example :
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
*/

fun main() {
    twoSum(numbers = intArrayOf(2,7,11,15), target = 9)
    twoSum(numbers = intArrayOf(2,3,4), target = 6)
    twoSum(numbers = intArrayOf(-1,0), target = -1)
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var low = 0
    var high = numbers.size - 1

    while (low < high) {
        if (numbers[low] + numbers[high] == target) {
            break
        }
        if (numbers[low] + numbers[high] < target) {
            low++
        } else {
            high--
        }
    }

    val result = intArrayOf(++low, ++high)
    println("Result is ${result.toList()}")

    return result
}