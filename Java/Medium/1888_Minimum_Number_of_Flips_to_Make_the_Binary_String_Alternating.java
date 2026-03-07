/*
Problem: Minimum Number of Flips to Make the Binary String Alternating
Problem No: 1888
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Sliding Window
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given a binary string s.

You can perform two operations:

Type-1: Move the first character to the end.
Type-2: Flip any character (0 → 1 or 1 → 0).

Return the minimum number of flips needed to make
the string alternating.

----------------------------------
Key Observation:
----------------------------------
Because of rotation (Type-1), the string can start
from any index.

To simulate all rotations:
→ duplicate the string

Example:
s = "111000"
t = s + s = "111000111000"

Now check every window of size n.

----------------------------------
Alternating Patterns:
----------------------------------
Only two valid patterns exist:

Pattern 1: 010101...
Pattern 2: 101010...

We count mismatches against both patterns.

----------------------------------
Approach:
----------------------------------
1. Create t = s + s.
2. Generate two alternating patterns.
3. Use sliding window of length n.
4. Count mismatches with both patterns.
5. Track minimum flips required.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)

Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int minFlips(String s) {

        int n = s.length();
        String t = s + s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i < 2 * n; i++) {
            alt1.append(i % 2 == 0 ? '0' : '1');
            alt2.append(i % 2 == 0 ? '1' : '0');
        }

        int diff1 = 0;
        int diff2 = 0;

        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < 2 * n; right++) {

            if (t.charAt(right) != alt1.charAt(right)) diff1++;
            if (t.charAt(right) != alt2.charAt(right)) diff2++;

            if (right - left + 1 > n) {

                if (t.charAt(left) != alt1.charAt(left)) diff1--;
                if (t.charAt(left) != alt2.charAt(left)) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}
