package algorithms

/*
You are given an array people where people[i] is the weight of the ith person,
and an infinite number of boats where each boat can carry a maximum weight of limit.
Each boat carries at most two people at the same time,
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
*/

fun main() {
    numRescueBoats(people = intArrayOf(1,2), limit = 3)
    numRescueBoats(people = intArrayOf(3, 2, 2, 1), limit = 3)
    numRescueBoats(people = intArrayOf(3,5,3,4), limit = 5)
    numRescueBoats(people = intArrayOf(21,40,16,24,30), limit = 50)
}

fun numRescueBoats(people: IntArray, limit: Int): Int {
    people.sort()

    var min = 0
    var start = 0
    var end = people.lastIndex

    while (start <= end) {
        min++
        if(people[start] + people[end] <= limit){
            start++
        }
        end--
    }

    println(min)
    return min
}


/*
Bad solution:

fun numRescueBoats(people: IntArray, limit: Int): Int {
    var min = 0

    val peopleForDerive = people.toMutableList()
    var derivedMan = 0
    var currentBoat = limit

    while (derivedMan != people.size) {
        var firstMan = Pair(0, 0)
        var secondMan = Pair(0, 0)

        for (i in peopleForDerive.indices) {
            val weight = peopleForDerive[i]
            if (firstMan.first == 0 && currentBoat >= weight) {
                firstMan = Pair(weight, i)
                derivedMan++
                currentBoat -= weight
                continue
            }

            if (currentBoat - weight >= 0 && weight > secondMan.first) {
                secondMan = Pair(weight, i - 1)
            }

            if (currentBoat == 0) {
                break
            }
        }

        peopleForDerive.removeAt(firstMan.second)
        if (secondMan.first != 0) {
            derivedMan++
            peopleForDerive.removeAt(secondMan.second)
        }

        currentBoat -= secondMan.first
        if (currentBoat >= 0) {
            min++
            currentBoat = limit
        }
    }

    println(min)
    return min
}*/
