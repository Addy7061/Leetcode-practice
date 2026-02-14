/*
Problem: Champagne Tower
Problem No: 799
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- Simulation

------------------------------------------------
Problem Summary:
------------------------------------------------
We pour champagne into the top glass of a pyramid.
Each glass holds 1 cup.

If a glass overflows:
- Excess liquid splits equally into the two glasses below it.

We must return how full a specific glass is.

------------------------------------------------
Approach:
------------------------------------------------
1. Use 2D DP array dp[101][101]
2. dp[i][j] = amount of champagne in glass (i, j)
3. If dp[i][j] > 1:
   - Overflow = (dp[i][j] - 1) / 2
   - Add overflow to dp[i+1][j] and dp[i+1][j+1]
4. At the end return min(1.0, dp[query_row][query_glass])

------------------------------------------------
Time Complexity:
O(100^2) → Constant (since max rows = 100)

Space Complexity:
O(100^2)

------------------------------------------------
*/

class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {

        double[][] dp = new double[101][101];
        dp[0][0] = poured;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= i; j++) {

                if (dp[i][j] > 1.0) {

                    double excess = (dp[i][j] - 1.0) / 2.0;

                    dp[i + 1][j] += excess;
                    dp[i + 1][j + 1] += excess;

                    dp[i][j] = 1.0; // glass can hold max 1 cup
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}
