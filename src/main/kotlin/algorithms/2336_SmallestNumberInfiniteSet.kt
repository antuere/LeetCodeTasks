package algorithms

import java.util.*

/*
You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].

Implement the SmallestInfiniteSet class:

SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive integers.
int popSmallest() Removes and returns the smallest integer contained in the infinite set.
void addBack(int num) Adds a positive integer num back into the infinite set,
if it is not already in the infinite set.*/

class SmallestInfiniteSet() {
    private val set = PriorityQueue<Int>()
    private var currentValue: Int = 1


    fun popSmallest(): Int {
        if (set.isEmpty()) {
            return currentValue++
        }

        return set.poll()
    }

    fun addBack(num: Int) {
        if (num < currentValue && !set.contains(num)) {
            set.add(num)
        }
    }

}