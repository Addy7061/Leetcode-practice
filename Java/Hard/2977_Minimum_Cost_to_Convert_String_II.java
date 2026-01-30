/*
Problem: Minimum Cost to Convert String II
Problem No: 2977
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Dynamic Programming
- Graph (Shortest Path)
- Floyd Warshall
- String Processing

----------------------------------
Problem Statement:
----------------------------------
You are given two strings `source` and `target` of equal length.
You can convert substrings of `source` to other substrings using
given transformation rules with costs.

Rules:
- Substring operations must be either completely disjoint
  or exactly the same substring.
- Each operation replaces a substring `x` with `y` at some cost.
- Goal: convert `source` to `target` with minimum cost.

Return -1 if conversion is impossible.

----------------------------------
Approach / Explanation:
----------------------------------
Key Observations:
- Substring conversions act like edges in a graph.
- Multiple conversions can be chained → shortest path problem.
- Overlapping substrings are not allowed → DP over string positions.

Steps:
1. Assign a unique ID to every string appearing in `original` and `changed`.
2. Build a directed weighted graph where:
   - Node = string
   - Edge = conversion with cost
3. Apply Floyd–Warshall to compute minimum cost between all string pairs.
4. Use Dynamic Programming:
   - dp[i] = minimum cost to convert source[0..i-1] to target[0..i-1]
5. At each index:
   - Either match characters directly (cost 0)
   - Or try all valid substring conversions starting at index `i`
6. Final answer = dp[n]

----------------------------------
Time & Space Complexity:
----------------------------------
Let:
- n = length of source
- V = number of unique strings (≤ 200)

Time Complexity:
- Floyd–Warshall: O(V³)
- DP: O(n × distinct substring lengths)

Space Complexity:
- O(V² + n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    static final long INF = (long) 1e18;

    public long minimumCost(
            String source,
            String target,
            String[] original,
            String[] changed,
            int[] cost
    ) {

        int n = source.length();
        if (n != target.length()) return -1;

        /* ---------- Step 1: Map strings to unique IDs ---------- */
        Map<String, Integer> strToId = new HashMap<>();
        int id = 0;

        for (int i = 0; i < original.length; i++) {
            if (!strToId.containsKey(original[i])) {
                strToId.put(original[i], id++);
            }
            if (!strToId.containsKey(changed[i])) {
                strToId.put(changed[i], id++);
            }
        }

        int V = id;

        /* ---------- Step 2: Build distance matrix ---------- */
        long[][] dist = new long[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = strToId.get(original[i]);
            int v = strToId.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        /* ---------- Step 3: Floyd–Warshall ---------- */
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < V; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        /* ---------- Step 4: Group strings by length ---------- */
        Map<Integer, List<String>> byLen = new HashMap<>();
        for (String s : strToId.keySet()) {
            byLen.computeIfAbsent(s.length(), x -> new ArrayList<>()).add(s);
        }

        /* ---------- Step 5: Dynamic Programming ---------- */
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            // Case 1: No operation (characters already match)
            if (source.charAt(i) == target.charAt(i)) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            }

            // Case 2: Try substring conversions
            for (int len : byLen.keySet()) {
                int end = i + len;
                if (end > n) continue;

                String sSub = source.substring(i, end);
                String tSub = target.substring(i, end);

                Integer u = strToId.get(sSub);
                Integer v = strToId.get(tSub);

                if (u == null || v == null) continue;
                if (dist[u][v] == INF) continue;

                dp[end] = Math.min(dp[end], dp[i] + dist[u][v]);
            }
        }

        return dp[n] == INF ? -1 : dp[n];
    }
}
