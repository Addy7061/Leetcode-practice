/*
Problem: Prime Number of Set Bits in Binary Representation
Problem No: 762
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation
- Math

------------------------------------------------
Problem Statement:
------------------------------------------------
Given two integers left and right,
return the count of numbers in range [left, right]
that have a PRIME number of set bits (1s) in their
binary representation.

------------------------------------------------
Key Observation:
------------------------------------------------
• Any number ≤ 10^6 has at most 20 bits.
• So set bits count ranges from 0 to 20.
• Prime numbers ≤ 20 are:
  {2, 3, 5, 7, 11, 13, 17, 19}

Instead of checking prime every time,
we use a bitmask for O(1) prime lookup.

------------------------------------------------
Bitmask Trick:
------------------------------------------------
If bit at position "x" is set,
then x is prime.

Example:
If setBits = 3
Check → (primeMask >> 3) & 1

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n) where n = right - left

Space Complexity:
------------------------------------------------
O(1)

------------------------------------------------
*/

class Solution {

    public int countPrimeSetBits(int left, int right) {

        // Prime positions up to 20:
        // 2,3,5,7,11,13,17,19
        int primeMask = 0b10100010100010101100;

        int count = 0;

        for (int i = left; i <= right; i++) {

            int setBits = Integer.bitCount(i);

            if (((primeMask >> setBits) & 1) == 1) {
                count++;
            }
        }

        return count;
    }
}
