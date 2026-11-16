import java.util.*;

class Solution {
    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // size 0 rhombus (single cell)
                set.add(grid[r][c]);

                for (int k = 1; ; k++) {

                    if (r - k < 0 || r + k >= m || c - k < 0 || c + k >= n)
                        break;

                    int sum = 0;

                    // top -> right
                    for (int i = 0; i < k; i++)
                        sum += grid[r - k + i][c + i];

                    // right -> bottom
                    for (int i = 0; i < k; i++)
                        sum += grid[r + i][c + k - i];

                    // bottom -> left
                    for (int i = 0; i < k; i++)
                        sum += grid[r + k - i][c - i];

                    // left -> top
                    for (int i = 0; i < k; i++)
                        sum += grid[r - i][c - k + i];

                    set.add(sum);
                }
            }
        }

        int size = Math.min(3, set.size());
        int[] ans = new int[size];

        int i = 0;
        for (int val : set) {
            if (i == size) break;
            ans[i++] = val;
        }

        return ans;
    }
}