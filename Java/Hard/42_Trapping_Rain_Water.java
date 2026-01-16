/*
Problem: Trapping Rain Water
Problem No: 42
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Array
- Two Pointers
- Dynamic Programming (conceptual)

----------------------------------
Problem Statement:
----------------------------------
Given an array `height` where each element represents the height
of a bar, compute how much water can be trapped after raining.

Each bar has width 1, and water can be trapped between bars
depending on the minimum of left and right maximum heights.

----------------------------------
Approach / Explanation:
----------------------------------
Two Pointer Approach (Optimal):

1. Initialize two pointers:
   - left at start
   - right at end
2. Maintain:
   - leftMax: maximum height seen from left
   - rightMax: maximum height seen from right
3. At each step:
   - Move the pointer with the smaller height.
   - If current height < corresponding max,
     water trapped = max - height.
4. Accumulate trapped water while moving pointers inward.
5. Continue until left < right.

This works because water trapped at any index depends on the
minimum of leftMax and rightMax.

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

    public int trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
