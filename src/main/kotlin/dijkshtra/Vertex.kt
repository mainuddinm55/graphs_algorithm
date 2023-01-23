package dijkshtra

import java.util.*

data class Vertex(
    val name: Int,
    val edges: LinkedList<Edge> = LinkedList(),
    //Initial cost is Infinity
    var cost: Int = Int.MAX_VALUE,
    //Initial previous vertex is null
    var prevVertex: Vertex? = null,
    //Define is spanning tree
    var isSpt: Boolean = false
) {
    fun addEdge(edge: Edge) {
        edges.add(edge)
    }
}
