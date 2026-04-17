/*
Problem: Minimum Absolute Distance Between Mirror Pairs
Problem No: 3761
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- HashMap
- Math

----------------------------------
Problem Statement:
----------------------------------
You are given an integer array nums.

A mirror pair (i, j) satisfies:
- i < j
- reverse(nums[i]) == nums[j]

Return the minimum absolute distance |i - j|
among all mirror pairs.

If no such pair exists → return -1.

----------------------------------
Key Idea:
----------------------------------

For each element nums[i]:
- Compute reversed value
- Check if reversed value already appeared before

Use HashMap:
value → last index

----------------------------------
Approach:
----------------------------------

1. Traverse array from left to right.
2. For each nums[i]:
   - Compute reverse(nums[i])
   - If reverse exists in map:
       → update minimum distance
3. Store current index in map

----------------------------------
Example:
----------------------------------

nums = [12,21,45,33,54]

i = 0 → 12 → reverse = 21 → not found
i = 1 → 21 → reverse = 12 → found at 0 → distance = 1
i = 4 → 54 → reverse = 45 → found at 2 → distance = 2

----------------------------------
Time Complexity:
----------------------------------

O(n * d)

d = number of digits (~10 max)

----------------------------------
Space Complexity:
----------------------------------

O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int minAbsoluteDistance(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int rev = reverse(nums[i]);

            if (map.containsKey(rev)) {
                ans = Math.min(ans, i - map.get(rev));
            }

            map.put(nums[i], i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int reverse(int x) {

        int res = 0;

        while (x > 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }

        return res;
    }
}
