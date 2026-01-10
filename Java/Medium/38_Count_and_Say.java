/*
Problem: Count and Say
Problem No: 38
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Simulation

----------------------------------
Problem Statement:
----------------------------------
The count-and-say sequence is defined as:
- countAndSay(1) = "1"
- countAndSay(n) is the run-length encoding of countAndSay(n - 1)

Given an integer n, return the nth term of the count-and-say sequence.

----------------------------------
Approach / Explanation:
----------------------------------
1. Start with the base string "1".
2. For each iteration from 2 to n:
   - Traverse the previous string.
   - Count consecutive identical characters.
   - Append count followed by the character to a StringBuilder.
3. Update the result string after each iteration.
4. Return the final string after n iterations.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * m)
Space Complexity: O(m)

(where m is the length of the generated string)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public String countAndSay(int n) {

        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }

            // Append the last group
            sb.append(count).append(result.charAt(result.length() - 1));
            result = sb.toString();
        }

        return result;
    }
}
