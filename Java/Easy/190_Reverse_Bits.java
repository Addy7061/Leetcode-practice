/*
Problem: Reverse Bits
Problem No: 190
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation

------------------------------------------------
Problem Statement:
------------------------------------------------
Reverse bits of a given 32-bit unsigned integer.

------------------------------------------------
Key Idea:
------------------------------------------------
We iterate through all 32 bits:

1. Shift result left by 1.
2. Extract last bit of n using (n & 1).
3. Add that bit to result.
4. Unsigned right shift n.

------------------------------------------------
Why Unsigned Shift (>>>):
------------------------------------------------
Because signed right shift (>>) may preserve sign bit.
We must treat the number as unsigned.

------------------------------------------------
Time Complexity:
O(32) → O(1)

Space Complexity:
O(1)

------------------------------------------------
Follow-up Optimization:
------------------------------------------------
If function is called many times:
- Precompute reversed values for all 8-bit numbers.
- Split 32-bit integer into 4 bytes.
- Reverse each byte using lookup table.
- Combine them.

This reduces repeated bit operations.

------------------------------------------------
*/

class Solution {

    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            result <<= 1;        // shift result left
            result |= (n & 1);   // add last bit of n
            n >>>= 1;            // unsigned right shift
        }

        return result;
    }
}
