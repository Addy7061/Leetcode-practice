/*
Problem: Combination Sum II
Problem No: 40
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Backtracking
- Recursion
- Sorting
- Pruning

----------------------------------
Problem Statement:
----------------------------------
Given an array of integers `candidates` (may contain duplicates)
and a target integer `target`, find all unique combinations where
the selected numbers sum to target.

Rules:
- Each number may be used at most once.
- The solution set must not contain duplicate combinations.

----------------------------------
Approach / Explanation:
----------------------------------
1. Sort the candidates array to easily handle duplicates.
2. Use Backtracking (DFS) to explore combinations.
3. At each recursion level:
   - Skip duplicate elements using:
       if (i > start && candidates[i] == candidates[i - 1]) continue;
4. Move to next index (i + 1) because each element can be used only once.
5. If target becomes 0 → valid combination found.
6. If target becomes negative → stop exploring that path.
7. Backtrack by removing the last chosen element.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(2^N)
Space Complexity: O(N)
  (recursion stack + temporary combination list)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort to handle duplicates
        Arrays.sort(candidates);

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

            // Skip duplicates at same recursion level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
