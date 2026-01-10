/*
Problem: Minimum ASCII Delete Sum for Two Strings
Problem No: 712
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- String

----------------------------------
Problem Statement:
----------------------------------
Given two strings s1 and s2, return the minimum ASCII sum of deleted
characters required to make the two strings equal.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Dynamic Programming where:
   dp[i][j] = minimum ASCII delete sum to make
              s1[i..] and s2[j..] equal.
2. Base cases:
   - If s1 is exhausted, delete all remaining characters of s2.
   - If s2 is exhausted, delete all remaining characters of s1.
3. If characters at i and j are equal:
   - No deletion needed → dp[i][j] = dp[i+1][j+1]
4. If characters are different:
   - Either delete s1[i] or delete s2[j], choose minimum cost.
5. Final answer is stored in dp[0][0].

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * m)
Space Complexity: O(n * m)

(where n = length of s1, m = length of s2)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Base cases: delete remaining characters
        for (int i = n - 1; i >= 0; i--) {
            dp[i][m] = dp[i + 1][m] + s1.charAt(i);
        }

        for (int j = m - 1; j >= 0; j--) {
            dp[n][j] = dp[n][j + 1] + s2.charAt(j);
        }

        // Fill DP table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(
                        s1.charAt(i) + dp[i + 1][j],
                        s2.charAt(j) + dp[i][j + 1]
                    );
                }
            }
        }

        return dp[0][0];
    }
}
