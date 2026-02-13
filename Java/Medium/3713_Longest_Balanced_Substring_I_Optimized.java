/*
Problem: Longest Balanced Substring I
Problem No: 3713
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- HashMap
- Prefix State Compression

------------------------------------------------
Approach:
------------------------------------------------
We check:
1) Single character substrings
2) Two-character balance using prefix difference
3) Three-character balance using state compression

Time Complexity: O(n)
Space Complexity: O(n)

------------------------------------------------
*/
class Solution {

    public int longestBalanced(String s) {
        char[] c = s.toCharArray();
        int n = c.length;

        int curA = 0, curB = 0, curC = 0;
        int maxA = 0, maxB = 0, maxC = 0;

        // Single character case
        for (int i = 0; i < n; i++) {
            if (c[i] == 'a') {
                curA = (i > 0 && c[i - 1] == 'a') ? curA + 1 : 1;
                maxA = Math.max(maxA, curA);
            } else if (c[i] == 'b') {
                curB = (i > 0 && c[i - 1] == 'b') ? curB + 1 : 1;
                maxB = Math.max(maxB, curB);
            } else {
                curC = (i > 0 && c[i - 1] == 'c') ? curC + 1 : 1;
                maxC = Math.max(maxC, curC);
            }
        }

        int res = Math.max(Math.max(maxA, maxB), maxC);

        // Two character combinations
        res = Math.max(res, find2(c, 'a', 'b'));
        res = Math.max(res, find2(c, 'a', 'c'));
        res = Math.max(res, find2(c, 'b', 'c'));

        // Three character combination
        res = Math.max(res, find3(c));

        return res;
    }

    private int find2(char[] c, char x, char y) {
        int n = c.length, maxLen = 0;
        int[] first = new int[2 * n + 1];
        Arrays.fill(first, -2);

        int clearIdx = -1, diff = n;
        first[diff] = -1;

        for (int i = 0; i < n; i++) {
            if (c[i] != x && c[i] != y) {
                clearIdx = i;
                diff = n;
                first[diff] = clearIdx;
            } else {
                diff += (c[i] == x) ? 1 : -1;

                if (first[diff] < clearIdx) {
                    first[diff] = i;
                } else {
                    maxLen = Math.max(maxLen, i - first[diff]);
                }
            }
        }

        return maxLen;
    }

    private int find3(char[] c) {
        long state = Long.MAX_VALUE / 2;
        Map<Long, Integer> first = new HashMap<>();
        first.put(state, -1);

        int maxLen = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a') state += 1_000_001;
            else if (c[i] == 'b') state -= 1_000_000;
            else state--;

            if (first.containsKey(state)) {
                maxLen = Math.max(maxLen, i - first.get(state));
            } else {
                first.put(state, i);
            }
        }

        return maxLen;
    }
}
