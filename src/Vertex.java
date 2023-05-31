import java.util.HashMap;
import java.util.Map;
public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjVertices;

    // Method to add an adjacent vertex with a weight
    public void addAdjVertex(Vertex<V> dest, double weight) {
        adjVertices.put(dest, weight);
    }
    // Method to get a copy of the map of adjacent vertices and their weights
    public Map<Vertex<V>, Double> getAdjVertices() {
        return new HashMap<>(adjVertices);
    }
    // Method to get the data of the vertex
    public V getData() {
        return data;
    }

    public Vertex(V data) {
        this.data = data;
        this.adjVertices = new HashMap<>();
    }

    @Override
    public String toString() {
        return "" + this.data;
    }
}