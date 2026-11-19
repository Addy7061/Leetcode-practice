class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        
        long[][][] dp = new long[zero + 1][one + 1][2];
        long[][] prefix0 = new long[zero + 1][one + 1]; // prefix0[i][j] = sum of dp[a][j][1] for a=0..i
        long[][] prefix1 = new long[zero + 1][one + 1]; // prefix1[i][j] = sum of dp[i][b][0] for b=0..j
        
        // Base cases
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        
        // Initialize prefix sums
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i > 0) prefix0[i][j] = (prefix0[i-1][j] + dp[i][j][1]) % MOD;
                else prefix0[i][j] = dp[i][j][1];
                
                if (j > 0) prefix1[i][j] = (prefix1[i][j-1] + dp[i][j][0]) % MOD;
                else prefix1[i][j] = dp[i][j][0];
            }
        }
        
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                if (i == 0 && j == 0) continue;
                
                // Ending with 0
                if (i > 0) {
                    int start = Math.max(0, i - limit);
                    long sum = prefix0[i-1][j];
                    if (start > 0) sum = (sum - prefix0[start-1][j] + MOD) % MOD;
                    dp[i][j][0] = (dp[i][j][0] + sum) % MOD;
                }
                
                // Ending with 1
                if (j > 0) {
                    int start = Math.max(0, j - limit);
                    long sum = prefix1[i][j-1];
                    if (start > 0) sum = (sum - prefix1[i][start-1] + MOD) % MOD;
                    dp[i][j][1] = (dp[i][j][1] + sum) % MOD;
                }
                
                // Update prefix sums
                if (i > 0) {
                    prefix0[i][j] = (prefix0[i-1][j] + dp[i][j][1]) % MOD;
                } else {
                    prefix0[i][j] = dp[i][j][1];
                }
                
                if (j > 0) {
                    prefix1[i][j] = (prefix1[i][j-1] + dp[i][j][0]) % MOD;
                } else {
                    prefix1[i][j] = dp[i][j][0];
                }
            }
        }
        
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}