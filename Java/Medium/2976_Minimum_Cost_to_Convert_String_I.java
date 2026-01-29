/*
Problem: Minimum Cost to Convert String I
Problem No: 2976
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Graph
- Shortest Path
- Floyd Warshall
- Dynamic Programming

----------------------------------
Problem Statement:
----------------------------------
You are given two strings `source` and `target` of equal length.
You are also given character transformation rules with costs.

In one operation, you can change a character x to y
if such a rule exists, paying its cost.

You can apply any number of transformations.
Find the minimum total cost to convert `source` to `target`.
If conversion is impossible, return -1.

----------------------------------
Approach / Explanation:
----------------------------------
This is a shortest path problem on characters.

Key observations:
- There are only 26 lowercase English letters.
- A character can be converted via multiple intermediate characters.

Steps:
1. Treat each character ('a' to 'z') as a node in a graph.
2. Initialize a 26x26 distance matrix.
3. Fill direct transformations using the given costs
   (take minimum if multiple rules exist).
4. Apply Floyd–Warshall to compute all-pairs shortest paths.
5. For each index i:
   - Add the minimum cost to convert source[i] → target[i].
   - If conversion is impossible, return -1.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity:
- Floyd Warshall: O(26³) ≈ constant
- Final traversal: O(n)
Total: O(n)

Space Complexity:
- O(26²) = constant space

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public long minimumCost(
            String source,
            String target,
            char[] original,
            char[] changed,
            int[] cost
    ) {

        final long INF = (long) 1e18;

        // distance matrix for 26 characters
        long[][] dist = new long[26][26];

        // initialization
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }

        // direct conversions
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Floyd–Warshall algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // compute total cost
        long totalCost = 0;
        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i) - 'a';
            int t = target.charAt(i) - 'a';

            if (dist[s][t] == INF) {
                return -1;
            }
            totalCost += dist[s][t];
        }

        return totalCost;
    }
}
