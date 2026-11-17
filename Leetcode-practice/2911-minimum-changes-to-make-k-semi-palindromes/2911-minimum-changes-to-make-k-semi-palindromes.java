
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Precompute minimum changes for every substring
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len <= n; l++) {
                int r = l + len - 1;
                cost[l][r] = Integer.MAX_VALUE;

                // Find all proper divisors
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;

                    int changes = 0;

                    for (int rem = 0; rem < d; rem++) {
                        int left = rem;
                        int right = rem + ((len - 1 - rem) / d) * d;

                        while (left < right) {
                            if (s.charAt(l + left) != s.charAt(l + right)) {
                                changes++;
                            }

                            left += d;
                            right -= d;
                        }
                    }

                    cost[l][r] = Math.min(cost[l][r], changes);
                }
            }
        }

        // DP: dp[i][j] = minimum changes to divide
        // first j characters into i semi-palindromes
        int INF = 1000000;
        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            java.util.Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int i = 1; i <= k; i++) {
            for (int j = 2 * i; j <= n; j++) {
                for (int p = 2 * (i - 1); p <= j - 2; p++) {

                    if (dp[i - 1][p] == INF) continue;

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i - 1][p] + cost[p][j - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}
