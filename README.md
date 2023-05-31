# Code Documentation

## Class: `MyGraph`

### Method: `DijkstraSearch(Vertex start)`

#### Description:
Performs Dijkstra's algorithm to find the shortest paths from a given starting vertex to all other vertices in the graph.

#### Parameters:
- `start` (Vertex): The starting vertex for Dijkstra's algorithm.

#### Returns:
- `Map<Vertex, Double>`: A map containing the shortest distances from the starting vertex to all other vertices. The keys represent the vertices, and the values represent the corresponding shortest distances.

#### Function:
```java
  public Map<Vertex, Double>  DijkstraSearch(Vertex start) {
        Map<Vertex, Double> distances = new HashMap<>();
        for (Vertex node : graph.keySet()) {
            distances.put(node, Double.MAX_VALUE);
        }
        distances.put(start, 0d);

        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        queue.add(start);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            List<Edge<V>> neighbors = graph.get(currentVertex);
            if (neighbors == null) {
                continue;
            }

            for (Edge<V> neighbor : neighbors) {
                Vertex<V> destination = neighbor.getDest();
                Double currentDistance = distances.get(currentVertex);
                if (currentDistance == null) {
                    continue;
                }
                double distance = currentDistance + neighbor.getWeight();

                Double destinationDistance = distances.get(destination);
                if (destinationDistance == null || distance < destinationDistance) {
                    distances.put(destination, distance);
                    queue.add(destination);
                }
            }
        }

        return distances;
    }
```

### Method: `BFS(Vertex start)`

#### Description:
Performs Breadth-First Search (BFS) starting from a given vertex.

#### Parameters:
- `start` (Vertex): The starting vertex for BFS.

#### Function:
```java
public void BFS(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            Map<Vertex<V>, Double> adjVertices = currentVertex.getAdjVertices();
            for (Vertex<V> neighbor : adjVertices.keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
```

### Method: `addEdge(Vertex source, Vertex destination, double weight)`

#### Description:
Adds a weighted edge between two vertices in the graph.

#### Parameters:
- `source` (Vertex): The source vertex of the edge.
- `destination` (Vertex): The destination vertex of the edge.
- `weight` (double): The weight of the edge.

#### Function:
```java
public void addEdge(Vertex source, Vertex destination, double weight){
    Edge edge = new Edge(source, destination, weight);
    source.addAdjVertex(destination, weight);
    if (!graph.containsKey(source)) graph.put(source, new ArrayList<>());
    graph.get(source).add(edge);
}
```



