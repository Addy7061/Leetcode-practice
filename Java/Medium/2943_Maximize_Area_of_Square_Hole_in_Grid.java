/*
Problem: Maximize Area of Square Hole in Grid
Problem No: 2943
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Sorting
- Greedy
- Geometry

----------------------------------
Problem Statement:
----------------------------------
You are given a grid formed by horizontal and vertical bars.

- There are (n + 2) horizontal bars and (m + 2) vertical bars.
- Some bars can be removed as specified in arrays hBars and vBars.

After removing bars, holes are formed.
Your task is to find the maximum possible area of a square-shaped hole.

----------------------------------
Approach / Explanation:
----------------------------------
1. A square hole is formed by removing consecutive bars.
2. If k consecutive bars are removed, the gap formed is (k + 1).
3. For horizontal bars:
   - Sort hBars.
   - Find the longest sequence of consecutive bar indices.
   - Horizontal side = longestConsecutive + 1.
4. Repeat the same for vertical bars.
5. The side of the largest square = min(horizontalSide, verticalSide).
6. Area = side × side.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(h log h + v log v)
Space Complexity: O(1) (excluding sorting)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {

        int maxH = maxConsecutiveGap(hBars);
        int maxV = maxConsecutiveGap(vBars);

        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private int maxConsecutiveGap(int[] bars) {
        Arrays.sort(bars);

        int maxLen = 1;
        int curr = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                curr++;
            } else {
                curr = 1;
            }
            maxLen = Math.max(maxLen, curr);
        }

        // Removing k consecutive bars creates a gap of size (k + 1)
        return maxLen + 1;
    }
}
