/*
Problem: The k-th Lexicographical String of All Happy Strings of Length n
Problem No: 1415
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Backtracking
- Recursion
- String

----------------------------------
Problem Statement:
----------------------------------
A happy string is defined as:

1. It consists only of characters from ['a', 'b', 'c'].
2. No two adjacent characters are equal.

Example valid strings:
"abc", "ac", "b"

Example invalid strings:
"aa", "baa"

Given integers n and k:
- Generate all happy strings of length n.
- Sort them lexicographically.
- Return the k-th string.

If fewer than k strings exist, return "".

----------------------------------
Key Idea:
----------------------------------
We generate strings using DFS / Backtracking.

Rules:
- Only characters {a, b, c}.
- Adjacent characters must be different.

Since we iterate characters in order:
a → b → c

The generated strings are automatically in
lexicographical order.

We simply count the generated strings and stop
when we reach the k-th one.

----------------------------------
Example:
----------------------------------
n = 3

Generated strings:
aba
abc
aca
acb
bab
bac
bca
bcb
cab
cac
cba
cbc

----------------------------------
Time Complexity:
----------------------------------
Maximum happy strings = 3 × 2^(n-1)

For n ≤ 10 → very small.

Time Complexity ≈ O(2^n)

----------------------------------
Space Complexity:
----------------------------------
O(n) recursion stack

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    int count = 0;
    String ans = "";

    public String getHappyString(int n, int k) {

        dfs(n, k, "");

        return ans;
    }

    private void dfs(int n, int k, String curr) {

        if (curr.length() == n) {

            count++;

            if (count == k) {
                ans = curr;
            }

            return;
        }

        for (char c : new char[]{'a','b','c'}) {

            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == c)
                continue;

            dfs(n, k, curr + c);

            if (!ans.equals(""))
                return;
        }
    }
}
