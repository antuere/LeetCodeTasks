package algorithms.trees

//   Created by AntuEre
//   User: a.cherevan   Date: 28.04.2023  Time: 10:20

class UnionFind(size: Int) {

    private val root = IntArray(size)
    private val rank = IntArray(size) { 1 }

    init {
        for (i in 0 until size) {
            root[i] = i
        }
    }

    fun find(x: Int): Int {
        if (x != root[x]) {
            root[x] = find(root[x])
        }
        return root[x]
    }

    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX
                return
            }

            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY
                return
            }

            root[rootY] = rootX
            rank[rootX]++
        }
    }

    fun isConnected(x: Int, y: Int) = find(x) == find(y)
}