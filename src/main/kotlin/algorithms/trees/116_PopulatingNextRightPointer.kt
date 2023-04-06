package algorithms.trees

import java.util.LinkedList
import java.util.Queue

/*
You are given a perfect binary tree where all leaves are on the same level,
and every parent has two children. The binary tree has the following definition:

Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

fun main() {
//    Sry no test, but its solution works fine!
}

fun connect(root: Node?): Node? {
    if (root == null) return null

    val queue: Queue<Node> = LinkedList()
    val checkedNodes = mutableMapOf<Node?, Int>(root to 0)
    queue.add(root)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val next = queue.peek()

        val currentDepth = checkedNodes[current]!!
        val nextDepth = checkedNodes[next] ?: -1

        if (next != null && currentDepth == nextDepth) {
            current?.next = next
        }

        if (!checkedNodes.contains(current?.left)) {
            queue.add(current?.left)
            checkedNodes[current?.left] = currentDepth + 1
        }

        if (!checkedNodes.contains(current?.right)) {
            queue.add(current?.right)
            checkedNodes[current?.right] = currentDepth + 1
        }
    }

    return root
}
