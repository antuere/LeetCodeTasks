package algorithms

/*
Write a function that reverses a string.
The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

fun main() {
    reverseString(s = charArrayOf('h', 'e', 'l', 'l', '0'))
}

fun reverseString(s: CharArray) {
    var start = 0
    var end = s.size - 1

    while (start < end) {
        val temp = s[end]
        s[end] = s[start]
        s[start] = temp

        start++
        end--
    }

    println("Result is ${s.toList()}")
}