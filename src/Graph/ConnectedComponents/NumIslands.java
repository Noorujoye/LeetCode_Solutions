package Graph.ConnectedComponents;

import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumIslands {
    // Keeping your exact BFS method layout
    private void dfs(int row, int col, int[][] vis, int n, int m, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.poll();
            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {

                    if (Math.abs(delRow) + Math.abs(delCol) == 2) {
                        continue;
                    }

                    int nRow = r + delRow;
                    int nCol = c + delCol;


                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {

                        if (vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1') {
                            vis[nRow][nCol] = 1;
                            q.add(new Pair(nRow, nCol));
                        }
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length; // Fixed to grid[0].length for rectangular grids
        int count = 0;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Discovering a brand new island starting from 'L'
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, vis, n, m, grid);
                }
            }
        }
        return count;
    }

    static void main() {

    }
}

