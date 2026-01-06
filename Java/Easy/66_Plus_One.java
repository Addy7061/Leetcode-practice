/*
Problem: Plus One
Problem No: 66
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Math

----------------------------------
Problem Statement:
----------------------------------
You are given a large integer represented as an integer array digits,
where each element represents a digit of the number.

Increment the integer by one and return the resulting array of digits.

----------------------------------
Approach / Explanation:
----------------------------------
1. Traverse the array from right to left.
2. If a digit is less than 9, increment it and return the array.
3. If a digit is 9, set it to 0 and continue.
4. If all digits are 9, create a new array with an extra leading 1.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(1) (O(n) in worst case when a new array is created)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        // Traverse from the least significant digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If all digits were 9
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
