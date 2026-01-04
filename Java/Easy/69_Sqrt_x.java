/*
Problem: Sqrt(x)
Problem No: 69
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Binary Search
- Math

----------------------------------
Problem Statement:
----------------------------------
Given a non-negative integer x, return the square root of x rounded
down to the nearest integer.

You must not use any built-in exponent function or operator.

----------------------------------
Approach / Explanation:
----------------------------------
1. Handle edge cases where x is 0 or 1.
2. Use Binary Search between 1 and x / 2.
3. Calculate mid and compare mid * mid with x.
4. If mid * mid equals x, return mid.
5. If mid * mid is less than x, move right and store mid as a potential answer.
6. If mid * mid is greater than x, move left.
7. Return the stored answer after the loop ends.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log x)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sq = (long) mid * mid;

            if (sq == x) {
                return mid;
            } 
            else if (sq < x) {
                ans = mid;
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
