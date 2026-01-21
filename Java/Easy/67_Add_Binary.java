/*
Problem: Add Binary
Problem No: 67
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String
- Bit Manipulation
- Simulation

----------------------------------
Problem Statement:
----------------------------------
You are given two binary strings a and b.
Return their sum as a binary string.

Rules:
- Strings contain only '0' and '1'
- No leading zeros (except "0" itself)

----------------------------------
Approach / Explanation:
----------------------------------
1. Start from the end of both strings.
2. Add corresponding bits along with carry.
3. Append (sum % 2) to result.
4. Update carry as (sum / 2).
5. Continue until all bits and carry are processed.
6. Reverse the result to get final binary sum.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(max(n, m))
Space Complexity: O(max(n, m))

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}
