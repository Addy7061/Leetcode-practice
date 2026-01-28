/*
Problem: Subsets
Problem No: 78
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Backtracking
- Recursion
- Bit Manipulation (alternative approach)
- Combinatorics

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums containing unique elements,
return all possible subsets (the power set).

The solution must not contain duplicate subsets.
Subsets can be returned in any order.

----------------------------------
Approach / Explanation:
----------------------------------
We use BACKTRACKING to generate all subsets.

Idea:
- At every index, we have two choices:
  1. Include the current element
  2. Exclude the current element

Steps:
1. Start with an empty subset.
2. At each recursion call:
   - Add the current subset to the result.
3. Try including each remaining element and recurse.
4. Backtrack by removing the last added element.

This guarantees:
- All possible subsets are generated
- No duplicates (because input elements are unique)

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(2^n)
Space Complexity: O(n) for recursion stack (excluding output)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // add current subset
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);                  // choose
            backtrack(i + 1, nums, current, result); // explore
            current.remove(current.size() - 1);    // un-choose
        }
    }
}
