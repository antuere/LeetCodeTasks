package algorithms.trees

import java.util.*


fun main() {
    val testTree = TreeNode(1)
    testTree.right = TreeNode(2)
    testTree.right!!.right = TreeNode(3)
    testTree.right!!.left = TreeNode(4)
    testTree.right!!.right!!.right = TreeNode(5)
    testTree.right!!.right!!.left = TreeNode(6)
    testTree.right!!.right!!.left!!.right = TreeNode(7)
    testTree.right!!.right!!.left!!.right!!.right = TreeNode(8)

    println("Result is ${longestZigZag(testTree)}")
}

private var result = 0
fun longestZigZag(root: TreeNode?): Int {
    findMaxZigZag(root, 1, 0)
    findMaxZigZag(root, 2, 0)

    return result
}

// Better solution
fun findMaxZigZag(node: TreeNode?, direction: Int, depth: Int) {
    if (node == null) {
        return
    }
    result = Math.max(depth, result)
    if (direction == 1) {
        findMaxZigZag(node.left, 2, depth + 1)
        findMaxZigZag(node.right, 1, 1)
    }
    if (direction == 2) {
        findMaxZigZag(node.right, 1, depth + 1)
        findMaxZigZag(node.left, 2, 1)
    }
}


// Bad solution with TLE , so brut force
fun longestZigZag1(root: TreeNode?): Int {
    val stack = Stack<TreeNode>()
    val visited = mutableListOf<TreeNode?>()
    var result = 0
    stack.add(root)

    while (stack.isNotEmpty()) {
        val node = stack.pop()
        if (!visited.contains(node)) {
            visited.add(node)
            stack.add(node?.left)
            stack.add(node?.right)

            val leftStart = findMaxZigZag1(node, 1)
            val rightStart = findMaxZigZag1(node, 2)

            val tempMax = Math.max(leftStart, rightStart)
            result = Math.max(result, tempMax)
        }
    }
    return result
}

fun findMaxZigZag1(node: TreeNode?, direction: Int): Int {
    if (node == null || (node.left == null && node.right == null)) {
        return 0
    }

    var leftNode = 0
    var rightNode = 0
    if (direction == 1 && node.left != null) {
        leftNode = findMaxZigZag1(node.left, 2) + 1
    }
    if (direction == 2 && node.right != null) {
        rightNode = findMaxZigZag1(node.right, 1) + 1

    }

    return Math.max(leftNode, rightNode)
}