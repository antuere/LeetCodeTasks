package algorithms

/*
Given an integer n,
return true if it is a power of two.
Otherwise, return false.

An integer n is a power of two,
if there exists an integer x such that n == 2x.
*/

fun main() {

}

fun isPowerOfTwo(n: Int): Boolean {
    if (n.toString().first() == '-') return false
    return n and (n shr 1) == 1
}
