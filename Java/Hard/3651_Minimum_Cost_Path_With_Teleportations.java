/*
Problem: Minimum Cost Path with Teleportations
Problem No: 3651
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Graph
- Dijkstra
- State Space Search
- Priority Queue

----------------------------------
Problem Statement:
----------------------------------
You are given a grid where you start from the top-left cell (0,0)
and want to reach the bottom-right cell (m-1,n-1).

Moves allowed:
1. Normal move (Right / Down):
   - Cost = value of destination cell
2. Teleportation (at most k times):
   - Can teleport to ANY cell having value <= current cell
   - Cost = 0

Return the minimum total cost.

----------------------------------
Approach / Explanation:
----------------------------------
This is a shortest path problem with an extra state:
- Position (i, j)
- Number of teleports used so far

We use Dijkstra because:
- Edge weights are non-negative
- Teleportation edges have cost 0

State Representation:
(node_row, node_col, usedTeleports)

From each state:
1. Move Right / Down (normal cost)
2. Teleport to any cell with value <= current cell (if teleports left)

We maintain:
- dist[row][col][usedTeleports] = minimum cost

Priority Queue ensures minimum cost path is always expanded first.

----------------------------------
Time & Space Complexity:
----------------------------------
Let M = rows, N = cols

Time Complexity:
O((M * N * K) * log(M * N * K))

Space Complexity:
O(M * N * K)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    static class State {
        int r, c, used;
        long cost;

        State(int r, int c, int used, long cost) {
            this.r = r;
            this.c = c;
            this.used = used;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        long[][][] dist = new long[m][n][k + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dist[i][j], Long.MAX_VALUE);

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        dist[0][0][0] = 0;
        pq.offer(new State(0, 0, 0, 0));

        // Pre-store all cells for teleportation
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                cells.add(new int[]{i, j});

        int[] dr = {0, 1};
        int[] dc = {1, 0};

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.cost > dist[cur.r][cur.c][cur.used]) continue;

            if (cur.r == m - 1 && cur.c == n - 1)
                return (int) cur.cost;

            // Normal moves (right, down)
            for (int d = 0; d < 2; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < m && nc < n) {
                    long newCost = cur.cost + grid[nr][nc];
                    if (newCost < dist[nr][nc][cur.used]) {
                        dist[nr][nc][cur.used] = newCost;
                        pq.offer(new State(nr, nc, cur.used, newCost));
                    }
                }
            }

            // Teleportation
            if (cur.used < k) {
                for (int[] cell : cells) {
                    int x = cell[0], y = cell[1];
                    if (grid[x][y] <= grid[cur.r][cur.c]) {
                        if (cur.cost < dist[x][y][cur.used + 1]) {
                            dist[x][y][cur.used + 1] = cur.cost;
                            pq.offer(new State(x, y, cur.used + 1, cur.cost));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
