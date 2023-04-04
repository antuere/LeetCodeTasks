package algorithms

/*
Given two strings s1 and s2,
return true if s2 contains a permutation of s1,
or false otherwise.

In other words,
return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
*/

fun main() {
    checkInclusion(s1 = "ab", s2 = "eidbaooo")
    checkInclusion(s1 = "adc", s2 = "dcda")
    checkInclusion(s1 = "a", s2 = "ab")
    checkInclusion(s1 = "abc", s2 = "ccccbbbbaaaa")
    checkInclusion(s1 = "abc", s2 = "cccbabbbaaaa")
    checkInclusion(s1 = "abcdxabcde", s2 = "abcdeabcdx")
}

fun checkInclusion(s1: String, s2: String): Boolean {
    val s1Letters = HashMap<Char, Int>()
    val s2Letters = HashMap<Char, Int>()
    val k = s1.length

    s1.forEach {
        val freq = s1Letters.getOrDefault(it, 0)
        s1Letters[it] = freq + 1
    }

    for (i in 0 until k) {
        val freq = s2Letters.getOrDefault(s2[i], 0)
        s2Letters[s2[i]] = freq + 1
    }

    for (i in k until s2.length) {
        if (s1Letters == s2Letters) {
            println("true")
            return true
        }

        val previousMinus = s2Letters[s2[i - k]]!! - 1

        if (previousMinus == 0) {
            s2Letters.remove(s2[i - k])
        } else {
            s2Letters[s2[i - k]] = previousMinus
        }

        val freq = s2Letters.getOrDefault(s2[i], 0)
        s2Letters[s2[i]] = freq + 1
    }

    if (s1Letters == s2Letters) {
        println("true")
        return true
    }

    println("false")
    return false
}