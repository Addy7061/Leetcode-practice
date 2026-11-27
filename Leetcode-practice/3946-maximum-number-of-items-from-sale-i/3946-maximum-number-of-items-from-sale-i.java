
import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] value = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    value[i]++;
                }
            }
        }

        int NEG = -1000000000;
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG);
        dp[0] = 0;

        int ans = 0;

        for (int p = budget; p >= 1; p--) {
            int[] hasP = new int[budget + 1];
            Arrays.fill(hasP, NEG);

            for (int i = 0; i < n; i++) {
                if (items[i][1] != p) continue;

                int price = p;
                int val = value[i];

                for (int c = budget; c >= price; c--) {
                    if (dp[c - price] != NEG) {
                        hasP[c] = Math.max(
                            hasP[c], dp[c - price] + val
                        );

                        dp[c] = Math.max(
                            dp[c], dp[c - price] + val
                        );
                    }
                }
            }

            for (int c = 0; c <= budget; c++) {
                if (hasP[c] != NEG) {
                    int total = hasP[c] + (budget - c) / p;
                    ans = Math.max(ans, total);
                }
            }
        }

        return ans;
    }
}
