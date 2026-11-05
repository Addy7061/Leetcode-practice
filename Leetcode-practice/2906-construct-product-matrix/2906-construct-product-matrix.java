class Solution {

    public int[][] constructProductMatrix(int[][] grid) {

        int MOD = 12345;

        int n = grid.length, m = grid[0].length;
        int size = n * m;

        long[] prefix = new long[size];
        long[] suffix = new long[size];

        // flatten
        long[] arr = new long[size];
        int idx = 0;

        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val % MOD;
            }
        }

        // prefix
        prefix[0] = arr[0];
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i]) % MOD;
        }

        // suffix
        suffix[size - 1] = arr[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            suffix[i] = (suffix[i + 1] * arr[i]) % MOD;
        }

        // result
        int[][] res = new int[n][m];

        for (int i = 0; i < size; i++) {

            long left = (i == 0) ? 1 : prefix[i - 1];
            long right = (i == size - 1) ? 1 : suffix[i + 1];

            long val = (left * right) % MOD;

            res[i / m][i % m] = (int) val;
        }

        return res;
    }
}