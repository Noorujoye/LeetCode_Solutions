package Graph;

import java.util.ArrayList;

public class DfsTraversalUndirectedGraph {
    private void depth(int node , boolean[] vis, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> adj ) {
        vis[node] = true;
        list.add(node);

        for (Integer it : adj.get(node)) {
            if (vis[it] == false) {
                depth(it , vis , list , adj);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[adj.size() + 1];
        ArrayList<Integer> list = new ArrayList<>();
        depth(0 , vis , list  , adj);
        return list;
    }
    static void main(String[] args){

    }
}
