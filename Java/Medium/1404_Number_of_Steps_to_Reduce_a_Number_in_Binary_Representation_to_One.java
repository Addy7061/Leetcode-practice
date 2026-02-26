/*
Problem: Number of Steps to Reduce a Number in Binary Representation to One
Problem No: 1404
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Simulation
- Bit Manipulation
- Greedy

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a binary string s:

If number is even → divide by 2
If number is odd  → add 1

Return number of steps to reduce it to 1.

------------------------------------------------
Key Insight:
------------------------------------------------
Instead of converting to BigInteger,
simulate binary operations from right to left.

Rules:
- If bit + carry == 1 → odd case
      → add 1 (carry = 1)
      → then divide
      → steps += 2
- Else → even case
      → just divide
      → steps += 1

We ignore the MSB during loop.
If carry remains after finishing → add 1 step.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n)

Space Complexity:
------------------------------------------------
O(1)

------------------------------------------------
*/

class Solution {

    public int numSteps(String s) {

        int steps = 0;
        int carry = 0;

        // Traverse from right to left (ignore MSB)
        for (int i = s.length() - 1; i > 0; i--) {

            int bit = s.charAt(i) - '0';

            if (bit + carry == 1) {
                // Odd → add 1 then divide
                steps += 2;
                carry = 1;
            } else {
                // Even → divide only
                steps += 1;
            }
        }

        // If carry remains at MSB
        return steps + carry;
    }
}
