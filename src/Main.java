import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Visual representation of a graph:");

        System.out.println("      1\n" +
                "    /   \\\n" +
                "   2     3\n" +
                "  / \\   / \\\n" +
                " 4   5 6   7\n");

        MyGraph<Integer> myGraph = new MyGraph<>();
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        Vertex<Integer> v7 = new Vertex<>(7);

        myGraph.addEdge(v1, v2, 5);
        myGraph.addEdge(v1, v3, 6);
        myGraph.addEdge(v2, v4, 7);
        myGraph.addEdge(v2, v5, 8);
        myGraph.addEdge(v3, v6, 9);
        myGraph.addEdge(v3, v7, 10);


        System.out.println("Dijkstra's shortest path starting from v1:");
        Map<Vertex, Double> distances = myGraph. DijkstraSearch(v1);

        for (Map.Entry<Vertex, Double> entry : distances.entrySet()) {
            Vertex<Integer> vertex = entry.getKey();
            double distance = entry.getValue();
            System.out.println("Shortest distance from v1 to " + vertex + ": " + distance);
        }

        System.out.println("BFS traversal starting from v1:");
        myGraph.BFS(v1);

        System.out.println();

        System.out.println("Search method showcase: " +
                "v1 -> target: 5");

        System.out.println(myGraph.search(v1, 5));

        System.out.println("Search method showcase: " +
                "v1 -> target: 10");

        System.out.println(myGraph.search(v1, 10));

        System.out.println("Search method showcase: " +
                "v1 -> target: v2");

        System.out.println(myGraph.search(v1, v2));

    }
}