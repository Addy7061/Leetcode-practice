/*
Problem: Valid Number
Problem No: 65
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- String Parsing
- Finite State Validation
- Edge Case Handling

----------------------------------
Problem Statement:
----------------------------------
Given a string s, determine whether it is a valid number.

A valid number can be:
- An integer (with optional + / -)
- A decimal number
- A number with exponent (e or E)

Examples of valid numbers:
"2", "0089", "-0.1", "+3.14", "4.", "-.9",
"2e10", "-90E3", "3e+7", "+6e-1"

Examples of invalid numbers:
"abc", "1a", "1e", "e3", "99e2.5", "--6"

----------------------------------
Approach / Explanation:
----------------------------------
1. Trim leading and trailing spaces.
2. Traverse the string character by character.
3. Use flags to track:
   - seenDigit → whether a digit has appeared
   - seenDot   → whether '.' has appeared
   - seenExp   → whether 'e' or 'E' has appeared
4. Rules:
   - '+' or '-' allowed only at start or after e/E
   - '.' allowed only once and not after exponent
   - 'e'/'E' allowed only once and must follow a digit
   - After 'e', there must be a valid integer
5. At the end, ensure at least one digit exists.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public boolean isNumber(String s) {

        s = s.trim();

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            }
            else if (c == '+' || c == '-') {
                // sign allowed only at start or after exponent
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (c == '.') {
                // dot not allowed after exponent or twice
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            }
            else if (c == 'e' || c == 'E') {
                // exponent must follow a digit and appear once
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // must see digit after exponent
            }
            else {
                return false;
            }
        }

        return seenDigit;
    }
}
