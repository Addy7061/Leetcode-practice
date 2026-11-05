class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long total = 0;

        // total sum
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        // must be even
        if (total % 2 != 0) return false;

        long target = total / 2;

        // 1️⃣ horizontal cut
        long sum = 0;
        for (int i = 0; i < m - 1; i++) { // ensure non-empty
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }

            if (sum == target) return true;
        }

        // 2️⃣ vertical cut
        sum = 0;
        for (int j = 0; j < n - 1; j++) { // ensure non-empty
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
            }

            if (sum == target) return true;
        }

        return false;
    }
}