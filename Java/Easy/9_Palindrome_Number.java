/*
Problem: Palindrome Number
Problem No: 9
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Math

----------------------------------
Problem Statement:
----------------------------------
Given an integer x, return true if x is a palindrome,
and false otherwise.

An integer is a palindrome when it reads the same
backward as forward.

----------------------------------
Approach / Explanation:
----------------------------------
1. Negative numbers are not palindromes.
2. Numbers ending with 0 are not palindromes (except 0 itself).
3. Reverse only half of the number to avoid overflow.
4. Compare the original first half with the reversed second half.
5. Handle both even and odd length numbers.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log₁₀ x)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // Reverse half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Check for even and odd length numbers
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
