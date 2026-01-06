/*
Problem: Maximum Matrix Sum
Problem No: 1975
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Matrix
- Greedy
- Math

----------------------------------
Problem Statement:
----------------------------------
You are given an n x n integer matrix. You can perform the following operation
any number of times:

Choose any two adjacent elements and multiply both by -1.

Return the maximum possible sum of all elements in the matrix.

----------------------------------
Approach / Explanation:
----------------------------------
1. Convert all values to their absolute values and add them to the total sum.
2. Count how many negative numbers are present.
3. Track the minimum absolute value in the matrix.
4. If the count of negative numbers is even:
   - All numbers can be made positive.
5. If the count of negative numbers is odd:
   - One value must remain negative.
   - Subtract twice the smallest absolute value from the total sum.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n²)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public long maxMatrixSum(int[][] matrix) {

        long sum = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int val = matrix[i][j];

                if (val < 0) {
                    negativeCount++;
                }

                int absVal = Math.abs(val);
                sum += absVal;
                minAbs = Math.min(minAbs, absVal);
            }
        }

        // If odd number of negatives, one smallest absolute value remains negative
        if (negativeCount % 2 != 0) {
            sum -= 2L * minAbs;
        }

        return sum;
    }
}
