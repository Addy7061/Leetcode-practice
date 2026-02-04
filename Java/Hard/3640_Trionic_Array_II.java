/*
Problem: Trionic Array II
Problem No: 3640
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Dynamic Programming
- Array
- State Transitions

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given an integer array nums of length n.

A trionic subarray nums[l...r] exists if there are indices:
l < p < q < r such that:
1) nums[l...p]   is strictly increasing
2) nums[p...q]   is strictly decreasing
3) nums[q...r]   is strictly increasing

Return the maximum possible sum of any trionic subarray.

------------------------------------------------
Key Idea:
------------------------------------------------
We use Dynamic Programming with 4 states:

dp0 → fresh start (single element)
dp1 → first strictly increasing segment
dp2 → strictly decreasing segment
dp3 → final strictly increasing segment (valid trionic)

Only dp3 contributes to the final answer.

------------------------------------------------
Approach:
------------------------------------------------
1. Iterate through the array from left to right.
2. Update DP states based on comparisons with previous element.
3. Track maximum value of dp3.

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
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long NEG = Long.MIN_VALUE / 4;

        long[] dp0 = new long[n];
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long[] dp3 = new long[n];

        dp0[0] = nums[0];
        dp1[0] = dp2[0] = dp3[0] = NEG;

        long ans = NEG;

        for (int i = 1; i < n; i++) {

            // fresh start
            dp0[i] = nums[i];
            dp1[i] = dp2[i] = dp3[i] = NEG;

            // increasing transition
            if (nums[i] > nums[i - 1]) {
                dp1[i] = Math.max(
                        dp1[i - 1] + nums[i],
                        dp0[i - 1] + nums[i]
                );

                dp3[i] = Math.max(
                        dp3[i - 1] + nums[i],
                        dp2[i - 1] + nums[i]
                );
            }

            // decreasing transition
            if (nums[i] < nums[i - 1]) {
                dp2[i] = Math.max(
                        dp2[i - 1] + nums[i],
                        dp1[i - 1] + nums[i]
                );
            }

            ans = Math.max(ans, dp3[i]);
        }

        return ans;
    }
}
