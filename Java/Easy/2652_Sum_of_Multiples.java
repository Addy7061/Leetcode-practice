/*
Problem: Sum of Multiples
Problem No: 2652
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Math
- Loop

----------------------------------
Problem Statement:
----------------------------------
Given a positive integer n, find the sum of all integers in the range [1, n]
(inclusive) that are divisible by 3, 5, or 7.

Return the sum of all such numbers.

----------------------------------
Approach / Explanation:
----------------------------------
1. Initialize a variable to store the sum.
2. Traverse numbers from 1 to n.
3. Check if the current number is divisible by 3, 5, or 7.
4. If yes, add it to the sum.
5. Return the final sum.

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
    public int sumOfMultiples(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
