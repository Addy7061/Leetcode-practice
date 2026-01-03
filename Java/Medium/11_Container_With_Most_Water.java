/*
Problem: Container With Most Water
Problem No: 11
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Two Pointers
- Array
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given an integer array height where each element represents the height
of a vertical line drawn at that index.

Find two lines that together with the x-axis form a container that holds
the maximum amount of water.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use two pointers: one at the start and one at the end of the array.
2. Calculate the area formed by the two lines.
3. Move the pointer with the smaller height inward, since it limits the area.
4. Continue until the two pointers meet.
5. Keep track of the maximum area found.

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
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, h * width);

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
