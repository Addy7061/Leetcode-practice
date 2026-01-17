/*
Problem: Find the Largest Area of Square Inside Two Rectangles
Problem No: 3047
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Geometry
- Brute Force
- Math

----------------------------------
Problem Statement:
----------------------------------
You are given multiple axis-aligned rectangles on a 2D plane.
Each rectangle is defined by its bottom-left and top-right coordinates.

Your task is to find the maximum possible area of a square
that can fit inside the intersection region of at least two rectangles.

If no two rectangles intersect, return 0.

----------------------------------
Approach / Explanation:
----------------------------------
1. Since n ≤ 1000, we can check every pair of rectangles.
2. For each pair (i, j):
   - Compute the intersection rectangle:
       left   = max(x1_i, x1_j)
       bottom = max(y1_i, y1_j)
       right  = min(x2_i, x2_j)
       top    = min(y2_i, y2_j)
3. If left < right and bottom < top, the rectangles intersect.
4. The largest square that fits inside the intersection has:
       side = min(width, height)
5. Track the maximum possible side length.
6. Return (maxSide × maxSide).

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

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {

        int n = bottomLeft.length;
        long maxSide = 0;

        // Check all pairs of rectangles
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int left   = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int right  = Math.min(topRight[i][0], topRight[j][0]);
                int top    = Math.min(topRight[i][1], topRight[j][1]);

                // If rectangles intersect
                if (left < right && bottom < top) {
                    long width = right - left;
                    long height = top - bottom;
                    long side = Math.min(width, height);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }

        return maxSide * maxSide;
    }
}
