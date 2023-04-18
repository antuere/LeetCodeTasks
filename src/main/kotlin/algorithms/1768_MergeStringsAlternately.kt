package algorithms

/*
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other,
append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
*/

fun main() {
    println("Result is ${mergeAlternately("avdc", "qweqwvg")}")
}

fun mergeAlternately(word1: String, word2: String): String {
    val result = StringBuilder()

    for (i in 0 until Math.max(word1.length, word2.length)){
        if(i >= word1.length){
            result.append(word2.substring(i))
            break
        }

        if(i >= word2.length){
            result.append(word1.substring(i))
            break
        }

        result.append(word1[i])
        result.append(word2[i])
    }

    return result.toString()
}
