/*
Problem: Text Justification
Problem No: 68
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Arrays
- Strings
- Greedy
- Simulation

----------------------------------
Problem Statement:
----------------------------------
You are given an array of words and an integer maxWidth.

Format the text such that:
- Each line has exactly maxWidth characters.
- Text is fully justified (left and right).
- Extra spaces are distributed evenly.
- If spaces don't divide evenly, left slots get more spaces.
- The last line is left-justified.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a greedy approach to pack as many words as possible per line.
2. For each line:
   - Calculate total spaces needed = maxWidth - total characters of words.
3. If it is:
   - The last line OR
   - A line with only one word
   → Left justify (single spaces between words, rest at end).
4. Otherwise:
   - Distribute spaces evenly between words.
   - Extra spaces are added from the left.
5. Repeat until all words are processed.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * maxWidth)
Space Complexity: O(maxWidth)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int j = i + 1;

            // pack as many words as possible
            while (j < words.length && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            int wordCount = j - i;
            int spaces = maxWidth;

            for (int k = i; k < j; k++) {
                spaces -= words[k].length();
            }

            StringBuilder sb = new StringBuilder();

            // last line or single word -> left justified
            if (j == words.length || wordCount == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            }
            // fully justified
            else {
                int spaceBetween = spaces / (wordCount - 1);
                int extra = spaces % (wordCount - 1);

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k != j - 1) {
                        for (int s = 0; s < spaceBetween; s++) sb.append(" ");
                        if (extra > 0) {
                            sb.append(" ");
                            extra--;
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}
