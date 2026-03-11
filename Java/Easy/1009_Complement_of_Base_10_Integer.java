/*
Problem: Complement of Base 10 Integer
Problem No: 1009
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation

----------------------------------
Problem Statement:
----------------------------------
The complement of an integer is obtained by flipping
all bits in its binary representation.

Example:
5  -> binary 101
flip bits -> 010
result -> 2

Given an integer n, return its complement.

----------------------------------
Key Idea:
----------------------------------
We only flip the bits that belong to the number.

Example:
n = 5  -> 101

Create mask with same length:
mask = 111

Now XOR:
101 ^ 111 = 010

Result = 2

----------------------------------
Approach:
----------------------------------
1. If n == 0 → return 1.
2. Build a mask of all 1s having same bit length as n.
3. XOR n with mask.

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

    public int bitwiseComplement(int n) {

        if (n == 0)
            return 1;

        int mask = 0;
        int temp = n;

        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;
    }
}
