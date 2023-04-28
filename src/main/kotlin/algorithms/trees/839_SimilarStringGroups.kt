package algorithms.trees

/*Two strings X and Y are similar if we can swap two letters (in different positions) of X,
so that it equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
and "rats" and "arts" are similar,
but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.
Notice that "tars" and "arts" are in the same group even though they are not similar.
Formally, each group is such that a word is in the group if and
only if it is similar to at least one other word in the group.

We are given a list strs of strings where every string in strs is an
anagram of every other string in strs.
How many groups are there?



Example 1:
Input: strs = ["tars","rats","arts","star"]
Output: 2

Example 2:
Input: strs = ["omv","ovm"]
Output: 1*/

fun main() {
    val result = numSimilarGroups(arrayOf("tars", "rats", "arts", "star"))
    println("Result is $result")
}

fun numSimilarGroups(strs: Array<String>): Int {
    val unionFind = UnionFind(strs.size)
    var result = strs.size

    for (i in strs.indices) {
        for (j in i + 1 until strs.size) {
            if (isSimilar(strs[i], strs[j]) && !unionFind.isConnected(i, j)) {
                result--
                unionFind.union(i, j)
            }
        }
    }

    return result
}

fun isSimilar(s1: String, s2: String): Boolean {
    var diff = 0

    for (i in s1.indices) {
        if (s1[i] != s2[i]) {
            diff++
        }
    }

    return diff == 0 || diff == 2
}