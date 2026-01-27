/*
Problem: Combinations
Problem No: 77
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Backtracking
- Recursion
- Combinatorics

----------------------------------
Problem Statement:
----------------------------------
Given two integers n and k, return all possible combinations
of k numbers chosen from the range [1, n].

Combinations are unordered, meaning [1,2] and [2,1] are the same.

----------------------------------
Approach / Explanation:
----------------------------------
We use Backtracking to generate all combinations.

Steps:
1. Start from number 1 and go up to n.
2. At each step, choose the current number and move forward.
3. Stop recursion when the size of the current combination becomes k.
4. Backtrack to explore other possibilities.

This ensures no duplicates and all valid combinations are generated.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(C(n, k))
Space Complexity: O(k) (recursion stack + temporary list)

----------------------------------
Solution:
----------------------------------
*/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}
