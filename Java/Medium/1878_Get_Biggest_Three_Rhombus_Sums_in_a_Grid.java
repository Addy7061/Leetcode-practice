/*
Problem: Get Biggest Three Rhombus Sums in a Grid
Problem No: 1878
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Matrix
- Simulation
- Geometry
- Set / Sorting

----------------------------------
Problem Statement:
----------------------------------
You are given an m x n integer matrix grid.

A rhombus sum is defined as the sum of elements
on the border of a rhombus shape inside the grid.

The rhombus looks like a square rotated 45°.

The rhombus can also have size 0 (single cell).

Return the biggest three DISTINCT rhombus sums
in descending order.

If fewer than three distinct sums exist,
return all of them.

----------------------------------
Rhombus Definition:
----------------------------------

        top
         *
        * *
       *   *
      *     *
     *       *
    *         *
   *           *
    *         *
     *       *
      *     *
       *   *
        * *
         *
       bottom

----------------------------------
Approach:
----------------------------------

1. Iterate over every cell as the center.
2. Consider rhombus sizes (k).

For each size:
Check boundary validity:

top    = (r-k, c)
right  = (r, c+k)
bottom = (r+k, c)
left   = (r, c-k)

3. Sum the four edges:

top → right  
right → bottom  
bottom → left  
left → top  

4. Store sums in a TreeSet to:
- keep values sorted
- ensure distinct sums

5. Return the top 3 values.

----------------------------------
Time Complexity:
----------------------------------

m,n ≤ 50

Worst case rhombus sizes ≈ 25

Total complexity ≈

O(m × n × min(m,n))

≈ 50 × 50 × 25

Very safe.

----------------------------------
Space Complexity:
----------------------------------

O(K)  (distinct rhombus sums)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int[] getBiggestThree(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // size 0 rhombus
                set.add(grid[r][c]);

                for (int k = 1; ; k++) {

                    if (r - k < 0 || r + k >= m || c - k < 0 || c + k >= n)
                        break;

                    int sum = 0;

                    // top → right
                    for (int i = 0; i < k; i++)
                        sum += grid[r - k + i][c + i];

                    // right → bottom
                    for (int i = 0; i < k; i++)
                        sum += grid[r + i][c + k - i];

                    // bottom → left
                    for (int i = 0; i < k; i++)
                        sum += grid[r + k - i][c - i];

                    // left → top
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

            if (i == size)
                break;

            ans[i++] = val;
        }

        return ans;
    }
}
