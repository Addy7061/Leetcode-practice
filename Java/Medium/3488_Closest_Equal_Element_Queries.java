/*
Problem: Closest Equal Element Queries
Problem No: 3488
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- HashMap
- Binary Search
- Circular Array

----------------------------------
Problem Statement:
----------------------------------
You are given a circular array nums and queries.

For each query index q:
Find the minimum circular distance between index q
and any other index j such that:

nums[j] == nums[q]

If no such index exists → return -1.

----------------------------------
Key Idea:
----------------------------------

1. Store indices of each value using HashMap:
   value → sorted list of indices

2. For each query:
   - Find current index position in list (binary search)
   - Get previous and next occurrence (circular)
   - Compute minimum circular distance

----------------------------------
Circular Distance Formula:
----------------------------------

distance = min(|i - j|, n - |i - j|)

----------------------------------
Approach:
----------------------------------

1. Build map:
   value → list of indices

2. For each query:
   - If only one occurrence → -1
   - Else:
       - Binary search position
       - Get neighbors
       - Compute circular distance

----------------------------------
Time Complexity:
----------------------------------

Building map → O(n)

Each query → O(log n)

Total → O(n + q log n)

----------------------------------
Space Complexity:
----------------------------------

O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;

        // Step 1: value → indices mapping
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        // Step 2: Process each query
        for (int q : queries) {

            int val = nums[q];
            List<Integer> list = map.get(val);

            // Only one occurrence
            if (list.size() == 1) {
                ans.add(-1);
                continue;
            }

            // Step 3: Binary search for position
            int pos = Collections.binarySearch(list, q);

            int m = list.size();

            // Circular neighbors
            int prev = list.get((pos - 1 + m) % m);
            int next = list.get((pos + 1) % m);

            // Distances
            int d1 = Math.abs(q - prev);
            int d2 = Math.abs(q - next);

            // Circular distance
            d1 = Math.min(d1, n - d1);
            d2 = Math.min(d2, n - d2);

            ans.add(Math.min(d1, d2));
        }

        return ans;
    }
}
