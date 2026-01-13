/*
Problem: Separate Squares I
Problem No: 3453
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Search
- Geometry
- Prefix / Area Calculation

----------------------------------
Problem Statement:
----------------------------------
You are given multiple axis-aligned squares.
Each square is defined by bottom-left corner (x, y)
and side length l.

Find the minimum y-coordinate of a horizontal line
such that the total area of squares above the line
equals the total area of squares below the line.

Overlapping areas are counted multiple times.

----------------------------------
Key Observation:
----------------------------------
For a given horizontal line at height mid:
- Each square contributes some area below the line
  and some area above the line.
- Area contribution depends only on y and l (x is irrelevant).

----------------------------------
Approach / Explanation:
----------------------------------
1. Compute total area of all squares.
2. We want:
      area_below(line) = total_area / 2
3. Use Binary Search on y-coordinate:
   - Search range: [minY, maxY]
4. For a given mid:
   - For each square:
       • If mid <= bottom → contributes 0 below
       • If mid >= top → contributes full area
       • Else → partial area = (mid - bottom) * side
   - Sum all "below" areas
5. Compare with half of total area and adjust binary search.
6. Return the minimum y satisfying the condition.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * log R)
(where R is coordinate range)

Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public double separateSquares(int[][] squares) {

        double totalArea = 0;
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;

        // Calculate total area and bounds
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            totalArea += l * l;
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y + l);
        }

        double half = totalArea / 2.0;

        // Binary search on y-coordinate
        double low = minY, high = maxY;
        for (int i = 0; i < 60; i++) { // sufficient precision
            double mid = (low + high) / 2.0;
            double areaBelow = areaBelowLine(squares, mid);

            if (areaBelow < half) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double areaBelowLine(int[][] squares, double lineY) {
        double area = 0;

        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y + l;

            if (lineY <= y) {
                continue;
            } else if (lineY >= top) {
                area += l * l;
            } else {
                area += (lineY - y) * l;
            }
        }

        return area;
    }
}
