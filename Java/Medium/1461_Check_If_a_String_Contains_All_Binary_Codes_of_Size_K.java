/*
Problem: Check If a String Contains All Binary Codes of Size K
Problem No: 1461
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Sliding Window
- Bit Manipulation
- Hashing

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a binary string s and integer k,
return true if every possible binary code of
length k exists as a substring of s.

Total possible binary codes of length k = 2^k

------------------------------------------------
Key Insight:
------------------------------------------------
Instead of generating all substrings and storing
them as strings (which is slow), we use:

✔ Rolling Bitmask (Sliding Window)
✔ Boolean array to mark seen codes

We treat each k-length substring as a number.

------------------------------------------------
Approach:
------------------------------------------------
1. Total required codes = 2^k
2. Use a rolling integer mask to track last k bits.
3. Maintain boolean[] seen to track visited codes.
4. Reduce counter whenever a new code is found.
5. If counter becomes 0 → return true.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n)

Space Complexity:
------------------------------------------------
O(2^k)

------------------------------------------------
*/

class Solution {

    public boolean hasAllCodes(String s, int k) {

        int need = 1 << k;          // Total binary codes
        boolean[] seen = new boolean[need];

        int mask = 0;
        int allOnes = need - 1;     // Keep only last k bits

        for (int i = 0; i < s.length(); i++) {

            // Shift left and add current bit
            mask = ((mask << 1) & allOnes) | (s.charAt(i) - '0');

            // Start checking after first k characters
            if (i >= k - 1) {

                if (!seen[mask]) {
                    seen[mask] = true;
                    need--;

                    if (need == 0)
                        return true;    // Early exit
                }
            }
        }

        return false;
    }
}
