/*
Problem: Minimum Cost Path with Edge Reversals
Problem No: 3650
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Graph
- Dijkstra
- Shortest Path
- Priority Queue
- Edge Reversal

----------------------------------
Problem Statement:
----------------------------------
You are given a directed weighted graph with n nodes.

Each edge is given as:
    u -> v with cost w

Each node has a switch that can be used at most once.
When you arrive at a node u, you may:
- Reverse ONE of its incoming edges (v -> u) into (u -> v)
- Immediately traverse it with cost = 2 * w

The reversal is valid for that move only.

Find the minimum cost to travel from node 0 to node n - 1.
Return -1 if it is not possible.

----------------------------------
Approach / Explanation:
----------------------------------
Key Observation:
Reversing an incoming edge (v -> u) into (u -> v)
and traversing it with cost 2*w is equivalent to
adding a new edge u -> v with cost 2*w.

So we can:
1. Build a modified graph:
   - Original edge: u -> v with cost w
   - Reversed edge: v -> u with cost 2*w

2. Once the graph is built, the problem reduces to:
   👉 Find the shortest path from 0 to n-1

3. Since all edge weights are positive,
   we use Dijkstra’s Algorithm.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O((n + m) log n)
Space Complexity: O(n + m)

where:
- n = number of nodes
- m = number of edges

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public int minCost(int n, int[][] edges) {

        // adjacency list
        List<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // build graph
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new Edge(v, w));        // original edge
            graph[v].add(new Edge(u, 2 * w));    // reversed edge
        }

        // Dijkstra
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        pq.add(new long[]{0, 0}); // {node, cost}

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long cost = cur[1];

            if (cost > dist[u]) continue;

            for (Edge e : graph[u]) {
                long newCost = cost + e.cost;
                if (newCost < dist[e.to]) {
                    dist[e.to] = newCost;
                    pq.add(new long[]{e.to, newCost});
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
