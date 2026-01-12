/*
Problem: Minimum Time Visiting All Points
Problem No: 1266
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Math
- Geometry
- Array

----------------------------------
Problem Statement:
----------------------------------
Given n points on a 2D plane, visit all points in the given order.
In one second, you can move:
- vertically by 1 unit
- horizontally by 1 unit
- diagonally by 1 unit in both directions

Return the minimum time required to visit all points.

----------------------------------
Approach / Explanation:
----------------------------------
1. To move from point (x1, y1) to (x2, y2):
   - Horizontal distance = |x2 - x1|
   - Vertical distance   = |y2 - y1|
2. In one second, we can move diagonally (covering both x and y).
3. So, the minimum time required is:
      max(|x2 - x1|, |y2 - y1|)
4. Sum this value for all consecutive point pairs.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {

        int time = 0;

        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);

            time += Math.max(dx, dy);
        }

        return time;
    }
}
