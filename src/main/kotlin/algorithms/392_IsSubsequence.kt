package algorithms

/*
Given two strings s and t,
return true if s is a subsequence of t,
or false otherwise.

A subsequence of a string is a new string
that is formed from the original string by deleting some (can be none)
of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
*/

fun main() {

}

fun isSubsequence(s: String, t: String): Boolean {
    var currentIndex = 0

    outer@
    for (i in s.indices) {
        val char = s[i]

        for (j in currentIndex until t.length) {
            if (t[j] == char) {
                currentIndex = j + 1
                continue@outer
            }
        }
        return false

    }

    return true
}
