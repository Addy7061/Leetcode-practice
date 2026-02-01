/*
Problem: Divide an Array Into Subarrays With Minimum Cost I
Problem No: 3010
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given an integer array nums of length n.

You need to divide nums into 3 disjoint contiguous subarrays.
The cost of a subarray is the value of its first element.

Return the minimum possible sum of the cost of these 3 subarrays.

----------------------------------
Key Observation:
----------------------------------
- The first subarray MUST start at index 0, so its cost is nums[0].
- To minimize total cost, the first elements of the other two subarrays
  should be as small as possible.
- These two subarrays must start somewhere after index 0.
- So, we just need the TWO SMALLEST elements from nums[1...n-1].

----------------------------------
Approach:
----------------------------------
1. Take nums[0] as the first cost.
2. Find the smallest and second smallest values in the rest of the array.
3. Return their sum with nums[0].

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
    public int minimumCost(int[] nums) {

        int first = nums[0];

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // Find two smallest elements from index 1 onward
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return first + min1 + min2;
    }
}
