package algorithms

/*
Given a string s, find the length of the longest
substring
without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

fun main() {
    lengthOfLongestSubstring2("abcabcbb")
    lengthOfLongestSubstring2("bbbbb")
    lengthOfLongestSubstring2("pwwkew")
    lengthOfLongestSubstring2("au")
    lengthOfLongestSubstring2("")
    lengthOfLongestSubstring2("dvdf")
    lengthOfLongestSubstring2("qrsvbspk")
    lengthOfLongestSubstring2("tivatbxnsjvrbwqweyis")
    lengthOfLongestSubstring2("miwhguwnqscipeyuvdnxrlezlcsfmdlylihtedgwvlenrdjmizlbmqdxu")
}


// My first solution
fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    var currentStr = StringBuilder()

    for (char in s) {
        if (currentStr.contains(char)) {
            val deleteChar = currentStr.indexOf(char)

            currentStr = if (deleteChar == 0) {
                currentStr.deleteCharAt(0)
            } else {
                currentStr.delete(0, deleteChar + 1)
            }
        }
        currentStr.append(char)
        result = Math.max(result, currentStr.length)
    }

    println("Result is $result")
    return result
}


// My second solution
fun lengthOfLongestSubstring2(s: String): Int {
    var result = 0
    var i = 0
    var start = 0

    val letters = HashMap<Char, Int>()

    while (i < s.length) {
        if (letters.contains(s[i])) {
            start = Math.max(letters[s[i]]!!, start)
        }

        letters[s[i]] = i + 1
        result = Math.max(result, i - start + 1)
        i++
    }

    println("Result is $result")
    return result
}
