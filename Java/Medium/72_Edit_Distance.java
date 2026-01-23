/*
Problem: Edit Distance
Problem No: 72
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- String
- DP on Strings

----------------------------------
Problem Statement:
----------------------------------
Given two strings word1 and word2, return the minimum number
of operations required to convert word1 into word2.

Allowed Operations:
1. Insert a character
2. Delete a character
3. Replace a character

----------------------------------
Approach / Explanation:
----------------------------------
We use Dynamic Programming.

Let:
dp[i][j] = minimum operations to convert
           word1[0..i-1] → word2[0..j-1]

Base Cases:
- dp[i][0] = i  (delete all characters)
- dp[0][j] = j  (insert all characters)

Transition:
If characters match:
    dp[i][j] = dp[i-1][j-1]
Else:
    dp[i][j] = 1 + min(
        dp[i-1][j-1], // replace
        dp[i-1][j],   // delete
        dp[i][j-1]    // insert
    )

Final Answer:
dp[m][n]

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(m × n)
Space Complexity: O(m × n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace
                            Math.min(
                                    dp[i - 1][j], // delete
                                    dp[i][j - 1]  // insert
                            )
                    );
                }
            }
        }

        return dp[m][n];
    }
}
