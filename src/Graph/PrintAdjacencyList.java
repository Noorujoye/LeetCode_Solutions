package Graph;

import java.util.ArrayList;
import java.util.List;

public class PrintAdjacencyList {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();

        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
    static void main(String[] args) {
        PrintAdjacencyList p = new PrintAdjacencyList();
        int v = 5;

        // 2. Created a sample 2D array representing graph edges
        int[][] edges = {
                {0, 1},
                {0, 4},
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 3},
                {3, 4}
        };

        // 3. Call method to build the adjacency list
        List<List<Integer>> adjacencyList = p.printGraph(v, edges);

        // 4. Printed the graph to the console
        for (int i = 0; i < v; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            System.out.println(adjacencyList.get(i));
        }
    }
}
