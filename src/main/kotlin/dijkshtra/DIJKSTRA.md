## Dijkstra's Algorithm
<hr>
Dijkstra's algorithm allows us to find the shortest path between any two vertices of a dijkshtra.graph.

It differs from the minimum spanning tree because the shortest distance between two vertices might not include all the vertices of the dijkshtra.graph.

### How Dijkstra's Algorithm works
<hr>

1. Initially the dijkshtra.graph with default value

``` 
    //Initial cost is Infinity
    var cost: Int = Int.MAX_VALUE,
    //Initial previous vertex is null
    var prevVertex: dijkshtra.Vertex? = null,
    //Define is spanning tree
    var isSpt: Boolean = false
```

2. Define source cost 0
3. Find the min vertex which is not spanning tree
4. Set spanning tree true
5. Find the all edges and update if is not added into spanning tree and cost is minimum

### Sample Input
1. Number of edges
2. Edges pair with weight
3. Source vertices

```
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
```

### Output

```
Min cost from 0 to 0 => 0 By 0
Min cost from 0 to 1 => 8 By 0,3,1
Min cost from 0 to 3 => 5 By 0,3
Min cost from 0 to 2 => 9 By 0,3,1,2
Min cost from 0 to 4 => 7 By 0,3,4
```

Refs: [Dijkstra’sAlgorithm](https://www.programiz.com/dsa/dijkstra-algorithm)