package Graph;
import java.util.*;

public class BfsTraversalUndirectedGraph {
    /*
    1.) insert root node or first node according to index based into the queue.
    2.) loop, till the queue has element.
    3.) pop top and marked it as traversed or add into the traversedList.
    4.) now,  each node is connected to some nodes which is stored in adjacency List
    5.) loop on each index of list and if the node in the current list is not visited then visit it and add back to queue.
    repeat step  3 t0 5.
     */
    public ArrayList<Integer> bfs(int startIndex , ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean isVis[] = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex); // 0, because 0 based indexing
        isVis[startIndex] = true; //  means already visited now go for its neighbors

        while (!queue.isEmpty()) {
            Integer node = queue.poll(); // took element;
            bfs.add(node); // add as traversed
            for (Integer ele : adj.get(node)) {
                if (isVis[ele] == false) {
                    isVis[ele] = true;
                    queue.add(ele);
                }
            }
        }
        return bfs;
    }

    // FIXED: Added 'public' so the JVM can execute this program
    public static void main(String[] args){
        BfsTraversalUndirectedGraph solver = new BfsTraversalUndirectedGraph();

        // =========================================================================
        // CASE 1: 0-BASED INDEXED GRAPH
        // Vertices: 0, 1, 2, 3
        // Edges: (0-1), (0-2), (0-3)
        // =========================================================================
        int v0 = 4; // 4 vertices: 0, 1, 2, 3
        ArrayList<ArrayList<Integer>> adj0 = new ArrayList<>();
        for (int i = 0; i < v0; i++) {
            adj0.add(new ArrayList<>());
        }
        // Adding undirected edges
        adj0.get(0).add(1); adj0.get(1).add(0);
        adj0.get(0).add(2); adj0.get(2).add(0);
        adj0.get(0).add(3); adj0.get(3).add(0);

        ArrayList<Integer> res0 = solver.bfs(0 , adj0); // 0-based indexing
        System.out.println("0-Based BFS Result: " + res0);
        // Expected Output: [0, 1, 2, 3]



        // Vertices: 1 to 9 (Size of adj list must be V + 1 = 10)
        // Edges: (1-2), (1-6), (2-3), (2-4), (6-7), (6-9), (4-5), (7-8), (5-8)
        int v1 = 9;
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();

        // Initialize 10 lists (indices 0 to 9)
        for (int i = 0; i <= v1; i++) {
            adj1.add(new ArrayList<>());
        }

        // Notice: Index 0 is left completely empty!
        // Connecting your exact chalkboard graph edges:
        adj1.get(1).add(2); adj1.get(2).add(1);
        adj1.get(1).add(6); adj1.get(6).add(1);

        adj1.get(2).add(3); adj1.get(3).add(2);
        adj1.get(2).add(4); adj1.get(4).add(2);

        adj1.get(6).add(7); adj1.get(7).add(6);
        adj1.get(6).add(9); adj1.get(9).add(6);

        adj1.get(4).add(5); adj1.get(5).add(4);
        adj1.get(7).add(8); adj1.get(8).add(7);
        adj1.get(5).add(8); adj1.get(8).add(5);

        ArrayList<Integer> res1 = solver.bfs(1 , adj1); // 1-based indexing

        // Because your method starts at 0, 0 will be added to the result.
        // We can simply remove or skip the 0th element from the final list!
        if (!res1.isEmpty() && res1.get(0) == 0) {
            res1.remove(0);
        }
        System.out.println("1-Based BFS Result: " + res1);
        // Expected Output: [1, 2, 6, 3, 4, 7, 9, 5, 8]
    }
}
