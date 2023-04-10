package algorithms.trees

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
*/

fun main() {
//    Sry no test, but its solution works fine!
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }
    val result = ListNode(0)

    if (list1.`val` < list2.`val`) {
        result.`val` = list1.`val`
        result.next = mergeTwoLists(list2, list1.next)
    } else {
        result.`val` = list2.`val`
        result.next = mergeTwoLists(list1, list2.next)
    }

    return result
}