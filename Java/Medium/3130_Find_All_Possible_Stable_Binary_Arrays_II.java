/*
Problem: Find All Possible Stable Binary Arrays II
Problem No: 3130
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Dynamic Programming
- Prefix Sum Optimization
- Combinatorics

----------------------------------
Problem Statement:
----------------------------------
You are given three integers:

zero  → number of 0s
one   → number of 1s
limit → maximum allowed consecutive identical elements

A binary array is called stable if:
1. It contains exactly "zero" number of 0s.
2. It contains exactly "one" number of 1s.
3. No subarray longer than "limit" contains identical values.

Return the number of possible stable arrays.

Answer should be returned modulo 1e9 + 7.

----------------------------------
DP State Definition:
----------------------------------
dp[i][j][0] → number of arrays with:
              i zeros
              j ones
              ending with 0

dp[i][j][1] → number of arrays with:
              i zeros
              j ones
              ending with 1

----------------------------------
Transition:
----------------------------------

Ending with 0:
We append a block of k zeros (1 ≤ k ≤ limit)
after a sequence ending with 1.

Ending with 1:
We append a block of k ones (1 ≤ k ≤ limit)
after a sequence ending with 0.

Prefix sums allow us to compute these ranges quickly.

----------------------------------
Why Prefix Sum?
----------------------------------
Without prefix sums:
Time complexity → O(zero × one × limit)

With prefix sums:
Time complexity → O(zero × one)

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(zero × one)

Space Complexity: O(zero × one)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {

        int MOD = 1_000_000_007;

        long[][][] dp = new long[zero + 1][one + 1][2];

        long[][] prefix0 = new long[zero + 1][one + 1];
        long[][] prefix1 = new long[zero + 1][one + 1];

        // Base cases
        for (int i = 1; i <= Math.min(zero, limit); i++)
            dp[i][0][0] = 1;

        for (int j = 1; j <= Math.min(one, limit); j++)
            dp[0][j][1] = 1;

        // Initialize prefix sums
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i > 0)
                    prefix0[i][j] = (prefix0[i - 1][j] + dp[i][j][1]) % MOD;
                else
                    prefix0[i][j] = dp[i][j][1];

                if (j > 0)
                    prefix1[i][j] = (prefix1[i][j - 1] + dp[i][j][0]) % MOD;
                else
                    prefix1[i][j] = dp[i][j][0];
            }
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i == 0 && j == 0)
                    continue;

                // Ending with 0
                if (i > 0) {

                    int start = Math.max(0, i - limit);

                    long sum = prefix0[i - 1][j];

                    if (start > 0)
                        sum = (sum - prefix0[start - 1][j] + MOD) % MOD;

                    dp[i][j][0] = (dp[i][j][0] + sum) % MOD;
                }

                // Ending with 1
                if (j > 0) {

                    int start = Math.max(0, j - limit);

                    long sum = prefix1[i][j - 1];

                    if (start > 0)
                        sum = (sum - prefix1[i][start - 1] + MOD) % MOD;

                    dp[i][j][1] = (dp[i][j][1] + sum) % MOD;
                }

                // Update prefix sums
                if (i > 0)
                    prefix0[i][j] = (prefix0[i - 1][j] + dp[i][j][1]) % MOD;
                else
                    prefix0[i][j] = dp[i][j][1];

                if (j > 0)
                    prefix1[i][j] = (prefix1[i][j - 1] + dp[i][j][0]) % MOD;
                else
                    prefix1[i][j] = dp[i][j][0];
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
