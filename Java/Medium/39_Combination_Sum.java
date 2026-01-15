/*
Problem: Combination Sum
Problem No: 39
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Backtracking
- Recursion
- Array

----------------------------------
Problem Statement:
----------------------------------
Given an array of distinct integers `candidates` and a target integer `target`,
return all unique combinations of candidates where the chosen numbers sum to target.

- Each number may be chosen unlimited times.
- The order of combinations does not matter.
- Each combination must be unique.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Backtracking (DFS) to explore all possible combinations.
2. Start from a given index to avoid duplicate combinations.
3. At each step:
   - Choose the current number.
   - Reduce the target.
   - Recurse with the same index (since repetition is allowed).
4. If target becomes 0 → valid combination found.
5. If target becomes negative → stop exploring that path.
6. Backtrack by removing the last added number.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(N^(T/M))
  where N = number of candidates,
        T = target value,
        M = minimum candidate value

Space Complexity: O(T)
  (recursion depth + current combination)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) return;

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
