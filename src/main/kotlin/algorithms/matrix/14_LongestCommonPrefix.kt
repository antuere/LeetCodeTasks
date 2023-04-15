package algorithms.matrix

/*
Write a function to find the longest common prefix
string amongst an array of strings.

If there is no common prefix,
return an empty string "".


Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

fun main() {
// Solution works fine
}

fun longestCommonPrefix(strs: Array<String>): String {
    var result = ""

    outerLoop@ for (i in 0 until strs[0].length) {
        val currentChar = strs[0][i]
        for (j in strs.indices) {
            if (i >= strs[j].length || strs[j][i] != currentChar) {
                break@outerLoop
            }
        }
        result += currentChar
    }

    return result
}