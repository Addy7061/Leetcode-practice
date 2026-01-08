/*
Problem: Substring with Concatenation of All Words
Problem No: 30
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- String
- Sliding Window
- Hash Table

----------------------------------
Problem Statement:
----------------------------------
Given a string s and an array of strings words (all of the same length),
return all starting indices of substrings in s that are a concatenation
of each word in words exactly once and without any intervening characters.

----------------------------------
Approach / Explanation:
----------------------------------
1. Let wordLen be the length of each word and totalLen be
   wordLen * number of words.
2. Store frequency of each word in a HashMap (wordCount).
3. Use sliding window with offsets from 0 to wordLen - 1.
4. Move window in steps of wordLen:
   - If current substring exists in wordCount, add it to window map.
   - If frequency exceeds required, shrink window from the left.
5. When the window size matches number of words, record the starting index.
6. Reset window when an invalid word is found.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * wordLen)
Space Complexity: O(m)

(where n = length of s, m = number of unique words)

----------------------------------
Solution:
----------------------------------
*/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0 || s == null) {
            return result;
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) {
            return result;
        }

        // Frequency map of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        // Try each possible offset
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String sub = s.substring(j, j + wordLen);

                if (wordCount.containsKey(sub)) {
                    window.put(sub, window.getOrDefault(sub, 0) + 1);
                    count++;

                    // Shrink window if frequency exceeds
                    while (window.get(sub) > wordCount.get(sub)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Valid concatenation found
                    if (count == words.length) {
                        result.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }
}
