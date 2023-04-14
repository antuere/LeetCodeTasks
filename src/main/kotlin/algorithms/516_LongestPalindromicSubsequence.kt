package algorithms

fun main() {
    println("Result is ${longestPalindromeSubseq("bbbab")} ")
    println("Result is ${longestPalindromeSubseq("abbacaz")} ")
}

fun longestPalindromeSubseq(s: String): Int {
    if (s.isEmpty()) return 0
    val memo = Array(s.length) { IntArray(s.length) }

    return LPS(string = s, start = 0, end = s.lastIndex, memo = memo)
}

fun LPS(string: String, start: Int, end: Int, memo: Array<IntArray>): Int {
    if (memo[start][end] != 0) {
        return memo[start][end]
    }

    if (start == end) {
        return 1
    }

    if (start > end) {
        return 0
    }

    if (string[start] == string[end]) {
        memo[start][end] = 2 + LPS(string, start + 1, end - 1, memo)
    } else {
        memo[start][end] = Math.max(
            LPS(string, start, end - 1, memo),
            LPS(string, start + 1, end, memo)
        )
    }

    return memo[start][end]
}