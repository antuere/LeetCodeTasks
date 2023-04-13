package algorithms

/*
Given a string s, you can transform every letter individually
to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create.
Return the output in any order.

Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]
*/

fun main() {
    println("Result is ${letterCasePermutation("a1b2")}")
    println("Result is ${letterCasePermutation("3Z4")}")
    println("Result is ${letterCasePermutation("a1b2Z5")}")
    println("Result is ${letterCasePermutation("mQe")}")
}

fun letterCasePermutation(s: String): List<String> {
    val result = mutableListOf<String>()

    findLetterCasePermutation(s, result, 0, "")

    return result
}

fun findLetterCasePermutation(
    originalStr: String,
    result: MutableList<String>,
    start: Int,
    currentStr: String,
) {
    if (currentStr.length == originalStr.length) {
        result.add(currentStr)
        return
    }

    if (originalStr[start].isDigit()) {
        findLetterCasePermutation(originalStr, result, start + 1, currentStr + originalStr[start])
    } else {
        findLetterCasePermutation(originalStr, result, start + 1, currentStr + originalStr[start].toLowerCase())
        findLetterCasePermutation(originalStr, result, start + 1, currentStr + originalStr[start].toUpperCase())
    }
}

