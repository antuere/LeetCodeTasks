package algorithms

/*
Given two strings s and t,
determine if they are isomorphic.

Two strings s and t are isomorphic if the characters
in s can be replaced to get t.

All occurrences of a character must be replaced
with another character while preserving the order of characters.
No two characters may map to the same character,
but a character may map to itself.



Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "foo", t = "bar"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true
*/

fun main() {
   println("Result is ${isIsomorphic("egg", "add")}")
   println("Result is ${isIsomorphic("foo", "bar")}")
   println("Result is ${isIsomorphic("paper", "title")}")
}

fun isIsomorphic(s: String, t: String): Boolean {
    val firstChars = mutableMapOf<Char, MutableList<Int>>()
    val secondChars = mutableMapOf<Char, MutableList<Int>>()

    for (i in s.indices) {
        val temp1 = firstChars.getOrDefault(s[i], mutableListOf())
        temp1.add(i)
        firstChars[s[i]] = temp1

        val temp2 = secondChars.getOrDefault(t[i], mutableListOf())
        temp2.add(i)
        secondChars[t[i]] = temp2
    }

    return firstChars.values.containsAll(secondChars.values)
}
