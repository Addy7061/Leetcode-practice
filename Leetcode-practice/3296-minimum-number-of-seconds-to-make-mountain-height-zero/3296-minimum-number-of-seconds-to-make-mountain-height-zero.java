class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long)1e18;
        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean can(long time, int height, int[] workers) {

        long total = 0;

        for (int t : workers) {

            long l = 0, r = (long)1e6;

            while (l <= r) {
                long m = (l + r) / 2;

                long needed = (long)t * m * (m + 1) / 2;

                if (needed <= time)
                    l = m + 1;
                else
                    r = m - 1;
            }

            total += r;

            if (total >= height)
                return true;
        }

        return total >= height;
    }
}