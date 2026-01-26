/*
Problem: Minimum Absolute Difference
Problem No: 1200
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Sorting
- Arrays
- Greedy

----------------------------------
Problem Statement:
----------------------------------
Given an array of distinct integers arr, find all pairs of elements
with the minimum absolute difference of any two elements.

Each pair [a, b] must satisfy:
- a < b
- b - a is the minimum possible absolute difference
- Pairs must be returned in ascending order

----------------------------------
Approach / Explanation:
----------------------------------
Key Observation:
The minimum absolute difference can only occur between
two adjacent elements in the sorted array.

Steps:
1. Sort the array.
2. Traverse once to find the minimum difference between
   consecutive elements.
3. Traverse again to collect all pairs having this minimum difference.

Why it works:
- Sorting ensures closest values are adjacent.
- One pass finds the minimum, second pass collects valid pairs.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n)  (due to sorting)
Space Complexity: O(1) extra (excluding output list)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;

        // Step 1: Find minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
        }

        // Step 2: Collect all pairs with minDiff
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
