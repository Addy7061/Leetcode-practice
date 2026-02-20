/*
Problem: Special Binary String
Problem No: 761
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- String
- Recursion
- Greedy
- Sorting

------------------------------------------------
Problem Statement:
------------------------------------------------
A binary string is special if:
1) Number of 1's == Number of 0's
2) Every prefix has at least as many 1's as 0's

We can swap two consecutive special substrings.
Return the lexicographically largest string possible.

------------------------------------------------
Key Insight:
------------------------------------------------
This is similar to the "Parentheses Problem".

Treat:
1 -> '('
0 -> ')'

A special string behaves like a valid parentheses string.

Strategy:
1. Split the string into top-level special substrings.
2. Recursively optimize the inner part.
3. Sort the substrings in descending order.
4. Concatenate them.

------------------------------------------------
Why Sorting Works:
------------------------------------------------
Swapping consecutive special substrings allows us
to rearrange them freely at the same nesting level.

To maximize lexicographical order:
→ Sort in descending order.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n² log n) worst case (due to recursion + sorting)

Space Complexity:
------------------------------------------------
O(n) recursion + list storage

------------------------------------------------
*/

import java.util.*;

class Solution {

    public String makeLargestSpecial(String s) {

        if (s.length() <= 2) return s;

        List<String> substrings = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') balance++;
            else balance--;

            // Found a top-level special substring
            if (balance == 0) {

                String inner = s.substring(start + 1, i);

                substrings.add("1" + makeLargestSpecial(inner) + "0");

                start = i + 1;
            }
        }

        // Sort in descending lexicographical order
        Collections.sort(substrings, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();

        for (String str : substrings) {
            result.append(str);
        }

        return result.toString();
    }
}
