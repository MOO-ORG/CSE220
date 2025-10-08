# Topic 10: Graphs - Question Set

## Multiple Choice Questions (15 questions)

### Easy Level (4 questions)

1. **What is a graph in computer science?**
   a) A visual representation of numerical data
   b) A collection of nodes and edges that represent relationships
   c) A tree structure with additional constraints
   d) A linear data structure

   **Answer: b) A collection of nodes and edges that represent relationships**

2. **In graph terminology, what is a vertex?**
   a) An edge connecting two nodes
   b) A node or point in the graph
   c) The weight of an edge
   d) The path between two nodes

   **Answer: b) A node or point in the graph**

3. **What type of graph has edges with direction?**
   a) Undirected graph
   b) Weighted graph
   c) Directed graph (Digraph)
   d) Complete graph

   **Answer: c) Directed graph (Digraph)**

4. **What is the degree of a vertex in an undirected graph?**
   a) The number of edges incident to the vertex
   b) The weight of the vertex
   c) The distance from the root vertex
   d) The number of vertices adjacent to it

   **Answer: a) The number of edges incident to the vertex**

### Medium Level (4 questions)

5. **What is the time complexity of DFS (Depth-First Search) traversal?**
   a) O(V)
   b) O(E)
   c) O(V + E)
   d) O(V * E)

   **Answer: c) O(V + E)**

6. **Which data structure is typically used to implement BFS (Breadth-First Search)?**
   a) Stack
   b) Queue
   c) Priority Queue
   d) Hash Table

   **Answer: b) Queue**

7. **What is a strongly connected component in a directed graph?**
   a) A subgraph where every vertex is reachable from every other vertex
   b) A cycle in the graph
   c) A vertex with maximum degree
   d) An edge with maximum weight

   **Answer: a) A subgraph where every vertex is reachable from every other vertex**

8. **What is the space complexity of adjacency matrix representation?**
   a) O(V)
   b) O(E)
   c) O(V²)
   d) O(V + E)

   **Answer: c) O(V²)**

### Hard Level (4 questions)

9. **In Dijkstra's algorithm, what happens when we encounter a negative weight edge?**
   a) The algorithm works correctly
   b) The algorithm gives incorrect results
   c) The algorithm terminates immediately
   d) The algorithm runs indefinitely

   **Answer: b) The algorithm gives incorrect results**

10. **What is the time complexity of Kruskal's algorithm for finding MST?**
    a) O(V log V)
    b) O(E log E)
    c) O(V²)
    d) O(E log V)

    **Answer: b) O(E log E)**

11. **Which algorithm can detect negative cycles in a weighted directed graph?**
    a) Dijkstra's algorithm
    b) Floyd-Warshall algorithm
    c) Bellman-Ford algorithm
    d) Both b and c

    **Answer: d) Both b and c**

12. **What is the chromatic number of a complete graph with n vertices?**
    a) n
    b) n-1
    c) 2
    d) n/2

    **Answer: a) n**

### Expert Level (3 questions)

13. **In the context of network flow, what does the max-flow min-cut theorem state?**
    a) Maximum flow equals minimum cut capacity
    b) Maximum flow is always less than minimum cut
    c) Minimum cut is always zero
    d) Maximum flow depends on the number of vertices

    **Answer: a) Maximum flow equals minimum cut capacity**

14. **What is the time complexity of the Ford-Fulkerson algorithm using Edmonds-Karp implementation?**
    a) O(VE²)
    b) O(V²E)
    c) O(V³)
    d) O(VE)

    **Answer: a) O(VE²)**

15. **In graph theory, what is a Hamiltonian path?**
    a) A path that visits each edge exactly once
    b) A path that visits each vertex exactly once
    c) The shortest path between two vertices
    d) A cycle that includes all edges

    **Answer: b) A path that visits each vertex exactly once**

## Code Snippet Questions (5 questions)

### Question 1: Basic Graph Representation
```java
class Graph {
    private int V;
    private LinkedList<Integer>[] adj;
    
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList();
    }
    
    void addEdge(int v, int w) {
        adj[v].add(w);
    }
}
```
**What does this code represent and what type of graph does it create?**

**Answer:** This represents an adjacency list implementation of a directed graph. The `addEdge` method only adds an edge from v to w, making it a directed graph (digraph).

### Question 2: DFS Implementation
```java
void DFS(int v, boolean visited[]) {
    visited[v] = true;
    System.out.print(v + " ");
    
    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext()) {
        int n = i.next();
        if (!visited[n])
            DFS(n, visited);
    }
}
```
**What traversal algorithm is this and what is its key characteristic?**

**Answer:** This is Depth-First Search (DFS). Its key characteristic is that it explores as far as possible along each branch before backtracking, using recursion (or stack implicitly).

### Question 3: BFS Implementation
```java
void BFS(int s) {
    boolean visited[] = new boolean[V];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    
    visited[s] = true;
    queue.add(s);
    
    while (queue.size() != 0) {
        s = queue.poll();
        System.out.print(s + " ");
        
        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                visited[n] = true;
                queue.add(n);
            }
        }
    }
}
```
**What algorithm is this and what data structure is essential for its implementation?**

**Answer:** This is Breadth-First Search (BFS). The essential data structure is a Queue, which ensures vertices are visited level by level in the correct order.

### Question 4: Cycle Detection
```java
boolean hasCycleUtil(int v, boolean visited[], boolean recStack[]) {
    visited[v] = true;
    recStack[v] = true;
    
    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext()) {
        int n = i.next();
        if (!visited[n] && hasCycleUtil(n, visited, recStack))
            return true;
        else if (recStack[n])
            return true;
    }
    
    recStack[v] = false;
    return false;
}
```
**What does this algorithm detect and why is the `recStack` array necessary?**

**Answer:** This detects cycles in a directed graph. The `recStack` array tracks vertices in the current recursion path. A cycle exists if we encounter a vertex that's already in the current path (back edge).

### Question 5: Shortest Path Initialization
```java
int[] dist = new int[V];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;

PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());
pq.add(new Node(src, 0));
```
**This is the initialization for which shortest path algorithm and why is a PriorityQueue used?**

**Answer:** This is the initialization for Dijkstra's algorithm. A PriorityQueue (min-heap) is used to always process the vertex with the smallest distance first, ensuring optimal substructure property.

## Problem Solving Questions (15 questions)

### Easy Level (3 questions)

1. **Graph Creation Problem**
   Create a method to determine if two vertices are adjacent in an undirected graph represented using adjacency matrix.
   
   **Hint:** In an undirected graph, if vertex i is adjacent to vertex j, then matrix[i][j] = matrix[j][i] = 1.

2. **Basic Traversal Problem**
   Given a connected undirected graph, write a method to count the total number of vertices reachable from a given starting vertex using DFS.
   
   **Hint:** Use DFS traversal and count vertices as you visit them. All vertices in a connected graph should be reachable.

3. **Degree Calculation Problem**
   For an undirected graph represented as adjacency list, write a method to find the vertex with maximum degree.
   
   **Hint:** Iterate through each vertex and count the size of its adjacency list. Track the maximum degree found.

### Medium Level (3 questions)

4. **Connected Components Problem**
   Given an undirected graph, find the number of connected components.
   
   **Hint:** Run DFS from each unvisited vertex. Each DFS call discovers one connected component.

5. **Bipartite Graph Problem**
   Determine if a given undirected graph is bipartite (can be colored with two colors such that no adjacent vertices have the same color).
   
   **Hint:** Use BFS/DFS with coloring. If you can color the graph with two colors without conflicts, it's bipartite.

6. **Path Existence Problem**
   Given a directed graph and two vertices, determine if there exists a path from source to destination.
   
   **Hint:** Use DFS or BFS starting from source vertex. If you reach the destination vertex, a path exists.

### Hard Level (5 questions)

7. **Shortest Path in Unweighted Graph**
   Find the shortest path between two vertices in an unweighted graph and return the path length.
   
   **Hint:** Use BFS from the source vertex. BFS guarantees the shortest path in unweighted graphs. Track distances level by level.

8. **Detect Cycle in Undirected Graph**
   Implement an algorithm to detect if an undirected graph contains a cycle.
   
   **Hint:** Use DFS with parent tracking. If you encounter a visited vertex that's not the parent, there's a cycle.

9. **Topological Sorting Problem**
   Implement topological sorting for a Directed Acyclic Graph (DAG) using DFS.
   
   **Hint:** Use DFS and add vertices to result after processing all neighbors. Reverse the result or use a stack.

10. **Minimum Spanning Tree Problem**
    Implement Kruskal's algorithm to find the minimum spanning tree of a weighted undirected graph.
    
    **Hint:** Sort edges by weight, use Union-Find to detect cycles, add edges that don't create cycles until you have V-1 edges.

11. **All Pairs Shortest Path**
    Implement Floyd-Warshall algorithm to find shortest paths between all pairs of vertices.
    
    **Hint:** Use dynamic programming with three nested loops: k (intermediate vertex), i (source), j (destination).

### Expert Level (4 questions)

12. **Strongly Connected Components**
    Implement Kosaraju's algorithm to find all strongly connected components in a directed graph.
    
    **Hint:** Run DFS on original graph to get finish times, transpose the graph, run DFS on transposed graph in decreasing order of finish times.

13. **Network Flow Problem**
    Implement the Ford-Fulkerson algorithm with DFS to find maximum flow in a flow network.
    
    **Hint:** Build residual graph, find augmenting paths using DFS, update residual capacities, repeat until no augmenting path exists.

14. **Graph Coloring Problem**
    Implement a backtracking algorithm to solve the graph coloring problem with k colors.
    
    **Hint:** Use backtracking to assign colors to vertices. Check if current assignment is safe, backtrack if not possible.

15. **Traveling Salesman Problem (TSP)**
    Implement a dynamic programming solution for TSP using bitmask to represent visited cities.
    
    **Hint:** Use DP with state (current_city, visited_mask). Base case: all cities visited, return to start. Use bit manipulation for visited set.