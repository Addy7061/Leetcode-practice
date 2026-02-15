/*
Problem: Largest Rectangle in Histogram
Problem No: 84
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Stack
- Monotonic Stack
- Array

------------------------------------------------
Problem Summary:
------------------------------------------------
Given an array heights where each bar has width 1,
find the largest rectangular area in the histogram.

------------------------------------------------
Key Idea:
------------------------------------------------
Use a MONOTONIC INCREASING STACK.

For every bar:
- When current height is smaller than stack top height,
  we calculate area using the popped bar as height.
- Width is determined by current index and new stack top.

We push indices into stack.
At the end, push a dummy height 0 to flush stack.

------------------------------------------------
Approach:
------------------------------------------------
1. Traverse from i = 0 to n (inclusive).
2. Maintain increasing stack of indices.
3. If current height < stack top height:
      - Pop
      - Calculate width
      - Update maxArea
4. Push current index.
5. Return maxArea.

------------------------------------------------
Time Complexity:
O(n)

Space Complexity:
O(n)

------------------------------------------------
*/
class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int h = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}
