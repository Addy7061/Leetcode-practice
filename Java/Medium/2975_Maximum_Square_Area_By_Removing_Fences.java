/*
Problem: Maximum Square Area by Removing Fences From a Field
Problem No: 2975
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Sorting
- HashSet
- Geometry

----------------------------------
Problem Statement:
----------------------------------
You are given a rectangular field with horizontal and vertical fences.
Some fences can be removed.

Return the maximum area of a square-shaped field that can be formed
by removing some fences (possibly none).

If it is impossible to form a square, return -1.

The result should be returned modulo 10^9 + 7.

----------------------------------
Approach / Explanation:
----------------------------------
1. Add boundary fences:
   - Horizontal: 1 and m
   - Vertical: 1 and n
2. Sort all fence positions.
3. Compute all possible vertical distances between vertical fences
   and store them in a HashSet.
4. For horizontal fences:
   - Compute all possible distances.
   - If a distance exists in vertical distances,
     it can form a square side.
5. Track the maximum possible side length.
6. If max side = 0 → square not possible → return -1.
7. Otherwise, return (side × side) % MOD.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(H² + V²)
Space Complexity: O(V²)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    private static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        // Include boundary fences
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[h.length - 1] = m;
        for (int i = 0; i < hFences.length; i++) {
            h[i + 1] = hFences[i];
        }

        v[0] = 1;
        v[v.length - 1] = n;
        for (int i = 0; i < vFences.length; i++) {
            v[i + 1] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        // Store all vertical distances
        Set<Integer> verticalDiff = new HashSet<>();
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                verticalDiff.add(v[j] - v[i]);
            }
        }

        int maxSide = 0;

        // Check matching horizontal distances
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                int diff = h[j] - h[i];
                if (verticalDiff.contains(diff)) {
                    maxSide = Math.max(maxSide, diff);
                }
            }
        }

        if (maxSide == 0) return -1;

        long area = (long) maxSide * maxSide;
        return (int) (area % MOD);
    }
}
