package algorithms.trees


//   Created by AntuEre
//   User: a.cherevan   Date: 06.04.2023  Time: 13:16

//   Util class for tasks with next pointer

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}