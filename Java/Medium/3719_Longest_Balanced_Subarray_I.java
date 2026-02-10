/*
Problem: Longest Balanced Subarray I
Problem No: 3719
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- HashSet
- Brute Force

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given an integer array nums.

A subarray is called balanced if the number of
distinct even numbers is equal to the number of
distinct odd numbers in that subarray.

Return the length of the longest balanced subarray.

------------------------------------------------
Key Observation:
------------------------------------------------
- Balance depends on DISTINCT even and odd numbers.
- For every starting index, we can expand the subarray
  and track distinct evens and odds using HashSet.
- Whenever sizes of both sets become equal,
  the subarray is balanced.

------------------------------------------------
Approach:
------------------------------------------------
1. Iterate over all possible starting indices.
2. For each start, expand the subarray to the right.
3. Use two HashSets:
   - one for distinct even numbers
   - one for distinct odd numbers
4. If sizes of both sets match, update answer.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n²)
Space Complexity: O(n)

------------------------------------------------
Solution:
------------------------------------------------
*/
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int left = 0; left < n; left++) {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();

            for (int right = left; right < n; right++) {
                if ((nums[right] & 1) == 0) {
                    even.add(nums[right]);
                } else {
                    odd.add(nums[right]);
                }

                if (even.size() == odd.size()) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
}
