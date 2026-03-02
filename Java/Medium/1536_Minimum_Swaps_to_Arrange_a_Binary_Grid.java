/*
Problem: Minimum Swaps to Arrange a Binary Grid
Problem No: 1536
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Greedy
- Array
- Simulation

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given an n x n binary grid.

In one step:
You may swap two adjacent rows.

A grid is valid if:
All cells above the main diagonal are 0.

Return the minimum swaps required,
or -1 if impossible.

------------------------------------------------
Key Insight:
------------------------------------------------
For row i (0-indexed),
we need at least (n - 1 - i) trailing zeros.

Because:
All positions above diagonal must be zero.

So:
Instead of swapping the whole grid,
just track trailing zero counts per row.

------------------------------------------------
Approach:
------------------------------------------------
1. Compute trailing zero count for each row.
2. For each row i:
   - Required zeros = n - 1 - i
   - Find a row j ≥ i that satisfies requirement.
   - If none → return -1.
   - Bring row j to position i using adjacent swaps.
3. Count total swaps.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n^2)

Space Complexity:
------------------------------------------------
O(n)

------------------------------------------------
*/

class Solution {

    public int minSwaps(int[][] grid) {

        int n = grid.length;

        int[] trailingZeros = new int[n];

        // Step 1: Count trailing zeros in each row
        for (int i = 0; i < n; i++) {

            int count = 0;

            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }

            trailingZeros[i] = count;
        }

        int swaps = 0;

        // Step 2: Place rows correctly
        for (int i = 0; i < n; i++) {

            int required = n - 1 - i;

            int j = i;

            while (j < n && trailingZeros[j] < required) {
                j++;
            }

            if (j == n) return -1;

            // Bubble row j up to position i
            while (j > i) {

                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;

                swaps++;
                j--;
            }
        }

        return swaps;
    }
}
