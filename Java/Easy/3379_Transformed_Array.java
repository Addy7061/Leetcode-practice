/*
Problem: Transformed Array
Problem No: 3379
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Simulation
- Circular Array

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given an integer array nums that represents a circular array.

For each index i:
- If nums[i] > 0: move nums[i] steps to the right.
- If nums[i] < 0: move |nums[i]| steps to the left.
- If nums[i] == 0: result[i] = 0.

Because the array is circular, indices wrap around.

Return the transformed array.

------------------------------------------------
Key Observation:
------------------------------------------------
- Circular movement can be handled using modulo.
- To safely handle negative indices:
  ((i + nums[i]) % n + n) % n

------------------------------------------------
Approach:
------------------------------------------------
1. Create a result array of same size.
2. For each index i:
   - If nums[i] == 0, copy 0.
   - Else compute new index using modulo arithmetic.
   - Set result[i] = nums[newIndex].

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

------------------------------------------------
Solution:
------------------------------------------------
*/

class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int newIndex = ((i + nums[i]) % n + n) % n;
                result[i] = nums[newIndex];
            }
        }

        return result;
    }
}
