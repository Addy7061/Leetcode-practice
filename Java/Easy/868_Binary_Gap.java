/*
Problem: Binary Gap
Problem No: 868
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a positive integer n,
return the longest distance between any two
adjacent 1's in its binary representation.

If there are fewer than two 1's, return 0.

Distance = difference in bit positions.

------------------------------------------------
Example:
------------------------------------------------
n = 22
Binary = 10110

1's positions = 1, 2, 4 (from right, 0-indexed)
Distances = 2 and 1
Answer = 2

------------------------------------------------
Approach:
------------------------------------------------
1. Traverse bits from right to left.
2. Track last position of '1'.
3. Whenever a new '1' is found:
   → compute distance from previous '1'
   → update max distance.
4. Return max distance.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(log n)

Space Complexity:
------------------------------------------------
O(1)

------------------------------------------------
*/

class Solution {

    public int binaryGap(int n) {

        int lastIndex = -1;
        int maxDistance = 0;
        int position = 0;

        while (n > 0) {

            if ((n & 1) == 1) {

                if (lastIndex != -1) {
                    maxDistance = Math.max(maxDistance, position - lastIndex);
                }

                lastIndex = position;
            }

            n >>= 1;
            position++;
        }

        return maxDistance;
    }
}
