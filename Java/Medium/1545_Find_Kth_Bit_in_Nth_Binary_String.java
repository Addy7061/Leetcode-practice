/*
Problem: Find Kth Bit in Nth Binary String
Problem No: 1545
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Recursion
- Divide and Conquer
- Bit Manipulation
- String Pattern

------------------------------------------------
Problem Statement:
------------------------------------------------
S1 = "0"

Si = Si-1 + "1" + reverse(invert(Si-1))

Return the kth bit in Sn.

------------------------------------------------
Key Observations:
------------------------------------------------
Length of Sn = 2^n - 1

Structure of Sn:
Left  part  → Sn-1
Middle      → '1'
Right part  → reverse(invert(Sn-1))

Middle index:
mid = (2^n - 1 + 1) / 2 = 2^(n-1)

------------------------------------------------
Recursive Logic:
------------------------------------------------
If k == mid → return '1'

If k < mid → answer = solve(n-1, k)

If k > mid:
    mirrored position = len - k + 1
    bit = solve(n-1, mirrored position)
    return inverted bit

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n)

Space Complexity:
------------------------------------------------
O(n) recursion stack

------------------------------------------------
*/

class Solution {

    public char findKthBit(int n, int k) {
        return solve(n, k);
    }

    private char solve(int n, int k) {

        if (n == 1)
            return '0';

        int length = (1 << n) - 1;
        int mid = (length + 1) / 2;

        if (k == mid)
            return '1';

        if (k < mid) {
            return solve(n - 1, k);
        } else {

            int mirroredPosition = length - k + 1;
            char bit = solve(n - 1, mirroredPosition);

            return (bit == '0') ? '1' : '0';
        }
    }
}
