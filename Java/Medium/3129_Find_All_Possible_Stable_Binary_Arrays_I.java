/*
Problem: Find All Possible Stable Binary Arrays I
Problem No: 3129
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Dynamic Programming
- Memoization
- Recursion

----------------------------------
Problem Statement:
----------------------------------
You are given three integers:

zero  → number of 0s
one   → number of 1s
limit → maximum allowed consecutive identical values

A binary array is called stable if:
1. It contains exactly "zero" number of 0s.
2. It contains exactly "one" number of 1s.
3. No subarray longer than "limit" contains identical elements.

Return the number of possible stable arrays.

Answer should be returned modulo 1e9 + 7.

----------------------------------
DP State Definition:
----------------------------------
dp[z][o][last][cnt]

z    → remaining zeros
o    → remaining ones
last → last element placed (0 or 1)
cnt  → how many consecutive same elements at the end

----------------------------------
Transitions:
----------------------------------

If last == 0:
    Add another 0 if cnt < limit
    Add 1 and reset count

If last == 1:
    Add another 1 if cnt < limit
    Add 0 and reset count

----------------------------------
Base Case:
----------------------------------
If z == 0 and o == 0
→ valid array constructed

----------------------------------
Time Complexity:
----------------------------------
O(zero × one × limit)

Space Complexity:
----------------------------------
O(zero × one × limit)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    int MOD = 1000000007;
    int[][][][] dp;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {

        this.limit = limit;

        dp = new int[zero + 1][one + 1][2][limit + 1];

        for (int[][][] a : dp)
            for (int[][] b : a)
                for (int[] c : b)
                    java.util.Arrays.fill(c, -1);

        long ans = 0;

        if (zero > 0)
            ans = (ans + dfs(zero - 1, one, 0, 1)) % MOD;

        if (one > 0)
            ans = (ans + dfs(zero, one - 1, 1, 1)) % MOD;

        return (int) ans;
    }

    int dfs(int z, int o, int last, int cnt) {

        if (z == 0 && o == 0)
            return 1;

        if (dp[z][o][last][cnt] != -1)
            return dp[z][o][last][cnt];

        long res = 0;

        if (last == 0) {

            if (z > 0 && cnt < limit)
                res = (res + dfs(z - 1, o, 0, cnt + 1)) % MOD;

            if (o > 0)
                res = (res + dfs(z, o - 1, 1, 1)) % MOD;

        } else {

            if (o > 0 && cnt < limit)
                res = (res + dfs(z, o - 1, 1, cnt + 1)) % MOD;

            if (z > 0)
                res = (res + dfs(z - 1, o, 0, 1)) % MOD;
        }

        return dp[z][o][last][cnt] = (int) res;
    }
}
