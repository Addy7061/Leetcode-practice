/*
Problem: Capitalize the Title
Problem No: 2129
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- String
- Simulation

----------------------------------
Problem Statement:
----------------------------------
You are given a string title consisting of words separated by a single space.

Capitalize the string such that:
- If a word has length 1 or 2, convert it entirely to lowercase.
- Otherwise, capitalize the first letter and make the remaining letters lowercase.

Return the resulting capitalized title.

----------------------------------
Approach / Explanation:
----------------------------------
1. Split the title into words using space as a delimiter.
2. Convert each word to lowercase.
3. If the word length is greater than 2:
   - Capitalize its first character.
4. Append each processed word to a StringBuilder.
5. Join words with a single space and return the final string.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

(where n is the length of the string)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public String capitalizeTitle(String title) {

        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();

            if (word.length() > 2) {
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }

            sb.append(word);
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
