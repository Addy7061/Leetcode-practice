
import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        int m = queries.length;
        int[] ans = new int[m];

        // Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Store query and original index
        int[][] q = new int[m][2];

        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        // Sort queries by time
        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        // Frequency of requests for each server
        int[] count = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int i = 0; i < m; i++) {

            int start = q[i][0] - x;
            int end = q[i][0];

            // Add logs within the right boundary
            while (right < logs.length && logs[right][1] <= end) {

                int id = logs[right][0];

                if (count[id] == 0) {
                    active++;
                }

                count[id]++;
                right++;
            }

            // Remove logs outside the left boundary
            while (left < right && logs[left][1] < start) {

                int id = logs[left][0];

                count[id]--;

                if (count[id] == 0) {
                    active--;
                }

                left++;
            }

            // Servers with zero requests
            ans[q[i][1]] = n - active;
        }

        return ans;
    }
}
