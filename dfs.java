import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list

    // Constructor
    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // Recursive function for DFS starting from a given vertex
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (Integer neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // DFS traversal from a given source vertex
    void DFS(int v) {
        boolean visited[] = new boolean[V];

        System.out.println("Depth-First Traversal (starting from vertex " + v + "):");
        DFSUtil(v, visited);
    }
}

public class Main {
    public static void main(String args[]) {
        Graph graph = new Graph(7); // Create a graph with 7 vertices

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        int startingVertex = 0; // Choose the starting vertex for DFS

        graph.DFS(startingVertex);
    }
}
