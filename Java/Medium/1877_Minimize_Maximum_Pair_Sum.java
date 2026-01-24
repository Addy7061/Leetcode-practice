/*
Problem: Minimize Maximum Pair Sum in Array
Problem No: 1877
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Greedy
- Sorting
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given an array nums of even length n, pair up the elements
into n/2 pairs such that:

1. Each element is used exactly once.
2. The maximum pair sum is minimized.

Return the minimized maximum pair sum.

----------------------------------
Approach / Explanation:
----------------------------------
Greedy + Sorting approach:

1. Sort the array in ascending order.
2. Pair the smallest element with the largest element.
3. This balances large values with small ones and minimizes
   the maximum pair sum.
4. Track the maximum sum among all such pairs.

Why this works:
- Pairing large numbers together would increase the maximum sum.
- Pairing smallest with largest distributes values optimally.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n)
Space Complexity: O(1) (ignoring sort space)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int maxPairSum = 0;

        while (left < right) {
            maxPairSum = Math.max(maxPairSum, nums[left] + nums[right]);
            left++;
            right--;
        }

        return maxPairSum;
    }
}
