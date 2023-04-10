package algorithms.trees

import java.util.*

/*
Given the head of a singly linked list,
reverse the list,
return the reversed list.
*/

fun main() {
//    Sry no test, but its solution works fine!
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    val stack = Stack<Int>()
    var currentNode = head

    while (currentNode != null) {
        stack.add(currentNode!!.`val`)
        currentNode = currentNode.next
    }

    val result = ListNode(stack.pop())
    var tempNode: ListNode? = result

    while (stack.isNotEmpty()) {
        tempNode?.next = ListNode(stack.pop())
        tempNode = tempNode?.next
    }

    return result
}