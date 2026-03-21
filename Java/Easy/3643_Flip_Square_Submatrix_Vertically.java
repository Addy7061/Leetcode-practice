/*
Problem: Flip Square Submatrix Vertically
Problem No: 3643
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Matrix
- Simulation

----------------------------------
Problem Statement:
----------------------------------
You are given an m x n matrix.

You are also given:
- (x, y) → top-left corner of a square submatrix
- k → size of the square

You need to flip this submatrix vertically.

That means:
- Reverse the order of rows inside the square.

----------------------------------
Example:
----------------------------------

Before:
[5 6 7]
[9 10 11]
[13 14 15]

After:
[13 14 15]
[9 10 11]
[5 6 7]

----------------------------------
Approach:
----------------------------------

1. Iterate from top to middle of the square.
2. Swap rows:
   row x+i ↔ row x+k-1-i

3. For each column in the square:
   swap elements vertically.

----------------------------------
Key Observation:
----------------------------------

Only k/2 swaps needed.

----------------------------------
Time Complexity:
----------------------------------

O(k * k)

----------------------------------
Space Complexity:
----------------------------------

O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int i = 0; i < k / 2; i++) {

            int row1 = x + i;
            int row2 = x + k - 1 - i;

            for (int j = 0; j < k; j++) {

                int col = y + j;

                // swap vertically
                int temp = grid[row1][col];
                grid[row1][col] = grid[row2][col];
                grid[row2][col] = temp;
            }
        }

        return grid;
    }
}
