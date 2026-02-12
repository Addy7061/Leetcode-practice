/*
Problem: Longest Balanced Substring I
Problem No: 3713
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Brute Force
- Frequency Counting
- Hashing

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given a string s consisting of lowercase English letters.

A substring is called balanced if all distinct characters 
in the substring appear the same number of times.

Return the length of the longest balanced substring.

------------------------------------------------
Key Observation:
------------------------------------------------
For any substring:
- Let distinct = number of distinct characters
- Let maxFreq = maximum frequency of any character

If the substring is balanced:
    length == distinct * maxFreq

Because:
All characters must appear equal times.

------------------------------------------------
Approach:
------------------------------------------------
1. Fix starting index i.
2. Expand ending index j.
3. Maintain:
   - freq[26]
   - distinct count
   - max frequency
4. Check condition:
   length == distinct * maxFreq
5. Update maximum answer.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n²)
Space Complexity: O(1)  (26 letters only)

------------------------------------------------
Solution:
------------------------------------------------
*/

class Solution {

    public int longestBalanced(String s) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {

                int idx = s.charAt(j) - 'a';

                if (freq[idx] == 0) {
                    distinct++;
                }

                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);

                int length = j - i + 1;

                if (length == distinct * maxFreq) {
                    ans = Math.max(ans, length);
                }
            }
        }

        return ans;
    }
}
