package dijkshtra

import java.util.*

/**
9
0 1 10
0 3 5
1 2 1
1 3 2
2 4 4
3 4 2
3 2 9
3 1 3
4 2 6
0
 */
private val graph = mutableListOf<Vertex>()
private var source = 0

fun main() {
    takeInput()
    dijkstra(source)
    for (v in graph) {
        println("Min cost from $source to ${v.name} => ${v.cost} By ${getPrevVertices(v).reversed()}")
    }
}

private fun takeInput() {
    val scanner = Scanner(System.`in`)
    val numOfEdges = scanner.nextInt()
    for (i in 0 until numOfEdges) {
        val u = scanner.nextInt()
        val v = scanner.nextInt()
        val cost = scanner.nextInt()
        addEdge(u, v, cost)
    }
    source = scanner.nextInt()
    scanner.close()
}

private fun addEdge(u: Int, v: Int, cost: Int) {
    val uVertex = graph.find { it.name == u } ?: Vertex(u)
    val vVertex = graph.find { it.name == v } ?: Vertex(v)
    uVertex.addEdge(Edge(v, cost))
    graph.indexOf(uVertex).let {
        if (it == -1) {
            graph.add(uVertex)
        } else {
            graph.set(it, uVertex)
        }
    }
    graph.indexOf(vVertex).let {
        if (it == -1) {
            graph.add(vVertex)
        } else {
            graph.set(it, vVertex)
        }
    }
}

private fun dijkstra(source: Int) {
    graph.find { it.name == source }?.also {
        it.cost = 0
    }
    for (v in graph) {
        val min = graph.filter { !it.isSpt }.minBy { it.cost }
        min.isSpt = true
        for (edge in min.edges) {
            val g = graph.find { it.name == edge.toVertex }
            if (g != null && !g.isSpt) {
                relax(min, g, edge.edgeCost)
            }
        }
    }
}

private fun relax(u: Vertex, v: Vertex, cost: Int) {
    if (v.cost > (u.cost + cost)) {
        v.cost = u.cost + cost
        v.prevVertex = u
    }
}

fun getPrevVertices(v: Vertex): String {
    if (v.prevVertex != null) return v.name.toString() +","+ getPrevVertices(v.prevVertex!!)
    else return v.name.toString()
}