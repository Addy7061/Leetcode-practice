import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] cnt = new int[n + 1];
        for (int[] it : items) cnt[it[0]]++;

        // multipleSum[f] = number of items whose factor is a multiple of f
        int[] multipleSum = new int[n + 1];
        for (int f = 1; f <= n; f++) {
            int s = 0;
            for (int g = f; g <= n; g += f) s += cnt[g];
            multipleSum[f] = s;
        }

        long m = Long.MAX_VALUE;
        for (int[] it : items) m = Math.min(m, it[1]);

        // arr[i] = {price, d_i}, sorted by price
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = items[i][1];
            arr[i][1] = multipleSum[items[i][0]] - 1;
        }
        Arrays.sort(arr, (a, b) -> Long.compare(a[0], b[0]));

        long R = budget;
        long ans = 0;
        for (long[] a : arr) {
            long p = a[0], d = a[1];
            if (p >= 2 * m) break;
            long t = Math.min(d, R / p);
            R -= t * p;
            ans += 2 * t;
            if (t < d) break;
        }

        ans += R / m;
        return (int) ans;
    }
}