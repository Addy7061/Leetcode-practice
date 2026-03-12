/*
Problem: Maximize Spanning Tree Stability with Upgrades
Problem No: 3600
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Graph
- Minimum Spanning Tree
- Binary Search
- Disjoint Set Union (Union Find)
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given a graph with n nodes and edges.

Each edge has:
u, v  → endpoints
s     → strength
must  → whether the edge must be included (1) or optional (0)

You can perform at most k upgrades.
Each upgrade doubles the strength of an optional edge.

The stability of a spanning tree = minimum strength edge in the tree.

Return the maximum possible stability of a valid spanning tree.

If it is impossible to build a spanning tree, return -1.

----------------------------------
Key Idea:
----------------------------------
We want to maximize the minimum edge strength in the spanning tree.

So we binary search the answer:
Try a candidate stability value "target".

Check if we can build a spanning tree where
every edge has strength ≥ target (after upgrades).

----------------------------------
Feasibility Check:
----------------------------------
1. Add all mandatory edges first.
   - If strength < target → impossible
   - If cycle forms → invalid

2. Add optional edges greedily:
   - If strength ≥ target → use it
   - If strength * 2 ≥ target and upgrade available → upgrade and use

3. Use DSU to maintain connectivity.

----------------------------------
DSU (Union Find):
----------------------------------
Used to detect cycles and manage components.

Features:
- Path Compression
- Union by Rank

----------------------------------
Time Complexity:
----------------------------------
Sorting edges → O(E log E)

Binary search → log(2e5)

Each check → O(E α(N))

Total ≈ O(E log E + E log W)

----------------------------------
Space Complexity:
----------------------------------
O(N)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {

            int pa = find(a);
            int pb = find(b);

            if (pa == pb)
                return false;

            if (rank[pa] < rank[pb])
                parent[pa] = pb;
            else if (rank[pb] < rank[pa])
                parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        Arrays.sort(edges, (a, b) -> b[2] - a[2]);

        int low = 0, high = 200000;
        int ans = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);

        int upgrades = 0;
        int used = 0;

        // Mandatory edges
        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 1) {

                if (s < target)
                    return false;

                if (!dsu.union(u, v))
                    return false;

                used++;
            }
        }

        // Optional edges
        for (int[] e : edges) {

            int u = e[0];
            int v = e[1];
            int s = e[2];
            int must = e[3];

            if (must == 1)
                continue;

            if (dsu.find(u) == dsu.find(v))
                continue;

            if (s >= target) {

                dsu.union(u, v);
                used++;

            } else if (s * 2 >= target && upgrades < k) {

                upgrades++;
                dsu.union(u, v);
                used++;
            }

            if (used == n - 1)
                return true;
        }

        return used == n - 1;
    }
}
