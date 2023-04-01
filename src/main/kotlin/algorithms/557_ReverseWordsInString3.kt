package algorithms

/*
Given a string s,
reverse the order of characters
in each word within a sentence
while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
*/

fun main() {
    reverseWords(s = "Let's take LeetCode contest")
    reverseWords(s = "Test")
}

fun reverseWords(s: String): String {
    val result = StringBuilder()

    var start = 0
    var end: Int

    for (i in s.indices) {
        if (i == s.lastIndex) {
            end = s.lastIndex

            while (start <= end) {
                result.append(s[end])
                end--
            }

            continue
        }

        if (s[i] == ' ') {
            end = i - 1

            while (start <= end) {
                result.append(s[end])
                end--
            }

            result.append(" ")
            start = i + 1
        }
    }
    println("Result is - $result")

    return result.toString()

}