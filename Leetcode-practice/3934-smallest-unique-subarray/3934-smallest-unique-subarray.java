
import java.util.Arrays;

class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        int[] rank = nums.clone();
        int[] sa = new int[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        // Build Suffix Array using doubling
        for (int len = 1; len < n; len <<= 1) {
            long[] keys = new long[n];

            for (int i = 0; i < n; i++) {
                int second = (i + len < n)
                        ? rank[i + len] + 1 : 0;

                keys[i] = ((long)(rank[i] + 1) << 34)
                        | ((long)second << 17)
                        | i;
            }

            Arrays.sort(keys);

            int[] newRank = new int[n];

            int prev = (int)(keys[0] & 131071);
            sa[0] = prev;
            newRank[prev] = 0;

            int r = 0;

            for (int i = 1; i < n; i++) {
                int curr = (int)(keys[i] & 131071);

                int prevSecond = prev + len < n
                        ? rank[prev + len] : -1;

                int currSecond = curr + len < n
                        ? rank[curr + len] : -1;

                if (rank[prev] != rank[curr] ||
                    prevSecond != currSecond) {
                    r++;
                }

                newRank[curr] = r;
                sa[i] = curr;
                prev = curr;
            }

            rank = newRank;

            if (r == n - 1) {
                break;
            }
        }

        // Build inverse suffix array
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            pos[sa[i]] = i;
        }

        // Calculate LCP using Kasai's algorithm
        int[] lcp = new int[n];
        int h = 0;

        for (int i = 0; i < n; i++) {
            int p = pos[i];

            if (p == 0) {
                continue;
            }

            int j = sa[p - 1];

            while (i + h < n && j + h < n &&
                   nums[i + h] == nums[j + h]) {
                h++;
            }

            lcp[p] = h;

            if (h > 0) {
                h--;
            }
        }

        // Find minimum unique subarray length
        int ans = n;

        for (int i = 0; i < n; i++) {
            int maxLcp = lcp[i];

            if (i + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[i + 1]);
            }

            int required = maxLcp + 1;

            if (required <= n - sa[i]) {
                ans = Math.min(ans, required);
            }
        }

        return ans;
    }
}
