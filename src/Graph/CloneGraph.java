package Graph;

import java.util.*;

class Node {
    int val;
    List<Node> neighbors;

    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}
public class CloneGraph {

    private Node dfs(Node node , Map<Node,Node> map) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val);
        map.put(node , copy);
        for (Node neighbors : node.neighbors ) {
            copy.neighbors.add(dfs(neighbors, map));
        }
        return copy;
    }
    public Node cloneGraph(Node node) {
        Map<Node,Node> map = new HashMap<>();
        return dfs(node , map);
    }

    public static void main() {
        /*
        1 ----- 2
        |       |
        |       |
        4 ----- 3

        1 -> [2,4]

        2 -> [1,3]

        3 -> [2,4]

        4 -> [1,3]
         */

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cg = new CloneGraph();
        Node cloned = cg.cloneGraph(node1);
        cg.print(cloned);

    }

    public void print(Node cloned) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> vis = new HashSet<>();

        queue.offer(cloned);
        vis.add(cloned);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.val + "-> [ ");
            for (Node neighbors : curr.neighbors) {
                System.out.print(neighbors.val + ", ");
                if (!vis.contains(neighbors)) {
                    vis.add(neighbors);
                    queue.offer(neighbors);
                }
            }
            System.out.print("]\n");
        }
    }
}
