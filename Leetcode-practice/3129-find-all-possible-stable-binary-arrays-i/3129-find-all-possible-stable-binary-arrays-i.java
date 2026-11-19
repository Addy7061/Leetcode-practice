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