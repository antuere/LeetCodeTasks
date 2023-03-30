package algorithms

/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version.
You should minimize the number of calls to the API.
*/

fun main() {
    val result = firstBadVersion(2126753390)
    println("Result is $result")
}

fun firstBadVersion(n: Int): Int {
    var result = n

    var start = 1
    var middle = n / 2
    var end = n

    while (end != middle) {
        if (!isBadVersion(middle)) {
            start = middle
            middle = (end - start) / 2 + start + 1
        } else {
            end = middle
            middle = (end - start) / 2 + start - 1
        }
        result = middle
    }

    for (i in start..end) {
        if (isBadVersion(i)) {
            result = i
            break
        }
    }

    return result
}

private fun isBadVersion(version: Int) = version >= 1702766719