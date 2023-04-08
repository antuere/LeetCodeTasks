package algorithms.trees

/*
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and
a list (List[Node]) of its neighbors.

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed).
For example, the first node with val == 1, the second node with val == 2, and so on.
The graph is represented in the test case using an adjacency list.
An adjacency list is a collection of unordered lists used to represent a finite graph.
Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1.
You must return the copy of the given node as a reference to the cloned graph.
*/

fun main() {
//    Sry no test, but its solution works fine!
}

fun cloneGraph(node: UndirectedNode?): UndirectedNode? {
    if (node == null) return null
    val visitedNotes = mutableMapOf<UndirectedNode, UndirectedNode>()
    return dfs(node, visitedNotes)
}

fun dfs(node: UndirectedNode?, visitedNodes: MutableMap<UndirectedNode, UndirectedNode>): UndirectedNode? {
    if (node == null) return null
    if (visitedNodes.contains(node)) {
        return visitedNodes[node]
    }
    val copyNode = UndirectedNode(`val` = node.`val`)
    visitedNodes[node] = copyNode

    for (neighbor in node.neighbors) {
        copyNode.neighbors.add(dfs(neighbor, visitedNodes))
    }

    return copyNode
}