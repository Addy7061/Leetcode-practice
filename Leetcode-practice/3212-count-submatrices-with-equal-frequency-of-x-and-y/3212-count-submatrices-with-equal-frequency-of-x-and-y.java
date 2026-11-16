class Solution {
    public int numberOfSubmatrices(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] prefix = new int[m][n];
        int[][] xPrefix = new int[m][n];

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = 0;
                if (grid[i][j] == 'X') val = 1;
                else if (grid[i][j] == 'Y') val = -1;

                int xVal = (grid[i][j] == 'X') ? 1 : 0;

                // build prefix sum
                prefix[i][j] = val;
                xPrefix[i][j] = xVal;

                if (i > 0) {
                    prefix[i][j] += prefix[i - 1][j];
                    xPrefix[i][j] += xPrefix[i - 1][j];
                }

                if (j > 0) {
                    prefix[i][j] += prefix[i][j - 1];
                    xPrefix[i][j] += xPrefix[i][j - 1];
                }

                if (i > 0 && j > 0) {
                    prefix[i][j] -= prefix[i - 1][j - 1];
                    xPrefix[i][j] -= xPrefix[i - 1][j - 1];
                }

                // check condition
                if (prefix[i][j] == 0 && xPrefix[i][j] > 0)
                    ans++;
            }
        }

        return ans;
    }
}