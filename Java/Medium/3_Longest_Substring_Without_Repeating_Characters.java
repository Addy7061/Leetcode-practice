/*
Problem: Longest Substring Without Repeating Characters
Problem No: 3
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Sliding Window
- Hash Table

----------------------------------
Problem Statement:
----------------------------------
Given a string s, find the length of the longest substring
without repeating characters.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use the sliding window technique with two pointers.
2. Maintain a HashMap to store the last index of each character.
3. Expand the window using the right pointer.
4. If a character repeats within the current window,
   move the left pointer to one position after the previous
   occurrence of that character.
5. Update the maximum length during traversal.

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
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
