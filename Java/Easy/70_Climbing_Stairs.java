/*
Problem: Climbing Stairs
Problem No: 70
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Dynamic Programming
- Fibonacci
- Optimization

----------------------------------
Problem Statement:
----------------------------------
You are climbing a staircase with n steps.
At each step, you can climb either 1 step or 2 steps.

Return the number of distinct ways to reach the top.

----------------------------------
Approach / Explanation:
----------------------------------
1. This problem follows the Fibonacci pattern.
2. Let:
   - dp[i] = number of ways to reach step i
3. Recurrence relation:
   - dp[i] = dp[i - 1] + dp[i - 2]
4. Base cases:
   - dp[1] = 1
   - dp[2] = 2
5. To optimize space, instead of a DP array,
   we only store the last two values.

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

    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev1 = 1; // ways to reach step 1
        int prev2 = 2; // ways to reach step 2

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return prev2;
    }
}
