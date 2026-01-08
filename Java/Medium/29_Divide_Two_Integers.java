/*
Problem: Divide Two Integers
Problem No: 29
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Bit Manipulation
- Math

----------------------------------
Problem Statement:
----------------------------------
Given two integers dividend and divisor, divide two integers without
using multiplication, division, or mod operator.

The result should be truncated toward zero.

If the result overflows the 32-bit signed integer range,
return Integer.MAX_VALUE.

----------------------------------
Approach / Explanation:
----------------------------------
1. Handle the overflow case when dividend is Integer.MIN_VALUE
   and divisor is -1.
2. Determine the sign of the result using XOR.
3. Convert both numbers to positive using long to avoid overflow.
4. Repeatedly subtract the divisor using bit shifting to speed up
   the subtraction process.
5. Accumulate the result using powers of two.
6. Apply the sign and return the result.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Bit manipulation approach
        while (a >= b) {
            long temp = b;
            int multiple = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}
