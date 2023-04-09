package algorithms.trees

import java.util.Stack

/*
There is a directed graph of n colored nodes and m edges.
The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i]
is a lowercase English letter representing the color of the ith node in this graph (0-indexed).
You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k.
The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph,
or -1 if the graph contains a cycle.

Example 1:
Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a".
*/

fun main() {
    val edges1 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
    )

    val edges2 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(3, 5),
            intArrayOf(5, 6),
            intArrayOf(2, 7),
            intArrayOf(6, 7),
            intArrayOf(7, 8),
            intArrayOf(3, 8),
            intArrayOf(5, 8),
            intArrayOf(8, 9),
            intArrayOf(3, 9),
            intArrayOf(6, 9),
    )

    val edges3 = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(4, 6),
            intArrayOf(5, 7),
            intArrayOf(6, 8),
            intArrayOf(8, 9),
    )

//    largestPathValue(colors = "abaca", edges = edges1)
//    largestPathValue(colors = "hhqhuqhqff", edges = edges2)
    largestPathValue(colors = "eeyyeeyeye", edges = edges3)
}


fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val graphDependencies = mutableMapOf<Int, Int>()
    val colorsMap = mutableMapOf<Char, Int>()

    for (i in colors.indices) {
        graph[i] = mutableListOf()
    }

    for (edge in edges) {
        if(edge.first() == edge.last()){
            return  -1
        }
        graph[edge.first()]?.add(edge.last())
    }

    for (vertex in graph.keys) {
        try {
            countDependencies(graph, graphDependencies, vertex, mutableSetOf())
        } catch (e: IllegalArgumentException) {
            return -1
        }
    }

    val topologicalSortList = graphDependencies.toList().sortedByDescending { it.second }.map { it.first }

    topologicalSortList.forEachIndexed { index, i ->
        if (index == 0) {
            colorsMap[colors[i]] = colorsMap.getOrDefault(colors[i], 0) + 1
        } else if (topologicalSortList[index - 1] < i) {
            colorsMap[colors[i]] = colorsMap.getOrDefault(colors[i], 0) + 1
        }
    }

    val result = colorsMap.toList().sortedByDescending { it.second }[0].second
    println("result is: result is $result")
    return result
}

fun countDependencies(graph: Map<Int, List<Int>>, graphDependencies: MutableMap<Int, Int>, vertex: Int, visited: MutableSet<Int>): Int {
    visited.add(vertex)
    var count = 0
    val dependencies = graph[vertex] ?: emptyList()

    for (dependency in dependencies) {
        if (visited.contains(dependency)) {
//            throw IllegalArgumentException("Found circled graph!")
        }
        count++
        count += graphDependencies[dependency] ?: countDependencies(graph, graphDependencies, dependency, visited)
    }
    graphDependencies[vertex] = count
    return count
}

