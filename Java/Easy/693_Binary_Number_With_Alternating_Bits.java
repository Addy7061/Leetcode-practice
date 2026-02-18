/*
Problem: Binary Number with Alternating Bits
Problem No: 693
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a positive integer n, check whether its binary
representation has alternating bits.

That means:
No two adjacent bits should be the same.

Example:
5  -> 101  -> true
7  -> 111  -> false
11 -> 1011 -> false

------------------------------------------------
Approach:
------------------------------------------------
1. Extract the last bit using (n & 1).
2. Right shift the number.
3. Compare current bit with previous bit.
4. If they are equal → return false.
5. Continue until n becomes 0.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(log n)  → Number of bits in n

------------------------------------------------
Space Complexity:
------------------------------------------------
O(1)

------------------------------------------------
*/

class Solution {

    public boolean hasAlternatingBits(int n) {

        int previousBit = n & 1;
        n >>= 1;

        while (n > 0) {

            int currentBit = n & 1;

            if (currentBit == previousBit) {
                return false;
            }

            previousBit = currentBit;
            n >>= 1;
        }

        return true;
    }
}
