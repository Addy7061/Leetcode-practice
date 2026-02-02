/*
Problem: Divide an Array Into Subarrays With Minimum Cost II
Problem No: 3013
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Sliding Window
- Greedy
- TreeMap (Balanced BST)
- Two Multisets

----------------------------------
Problem Statement:
----------------------------------
You are given a 0-indexed array of integers nums of length n, and two integers
k and dist.

You need to divide nums into k disjoint contiguous subarrays.

The cost of a subarray is defined as the value of its first element.

Let the starting indices of subarrays be:
0, i1, i2, ..., ik-1

Then the following constraint must be satisfied:
ik-1 - i1 <= dist

Return the minimum possible sum of the costs of these k subarrays.
If no valid division exists, return the minimum achievable cost.

----------------------------------
Key Observations:
----------------------------------
- The first subarray always starts at index 0 → cost = nums[0]
- We must choose (k - 1) additional starting indices
- Among them:
  - i1 is the second subarray start
  - ik-1 is the last subarray start
- Constraint limits how far the last subarray can be from the second

----------------------------------
Core Idea:
----------------------------------
- Fix i1 (start of second subarray)
- The remaining (k - 2) subarrays must start within:
  [i1 + 1, i1 + dist]
- To minimize total cost:
  - Pick the smallest (k - 2) values in this window
- Maintain this window using two TreeMaps:
  - small → smallest (k - 2) elements
  - large → remaining elements

----------------------------------
Approach:
----------------------------------
1. Handle special case when k == 2
2. Use a sliding window over valid indices
3. Maintain two balanced multisets (TreeMaps)
4. Always keep exactly (k - 2) elements in `small`
5. Update answer for each valid i1

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n)
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long result = Long.MAX_VALUE;

        // Special case: only 2 subarrays
        if (k == 2) {
            for (int i = 1; i < n; i++) {
                result = Math.min(result, (long) nums[0] + nums[i]);
            }
            return result;
        }

        int needed = k - 2;

        TreeMap<Integer, Integer> small = new TreeMap<>();
        TreeMap<Integer, Integer> large = new TreeMap<>();

        long sumSmall = 0;
        int countSmall = 0;

        // Initial window: [2 .. 1 + dist]
        for (int i = 2; i <= Math.min(n - 1, 1 + dist); i++) {
            add(large, nums[i]);
        }

        // Fill `small` with smallest needed elements
        while (countSmall < needed && !large.isEmpty()) {
            int val = large.firstKey();
            remove(large, val);
            add(small, val);
            sumSmall += val;
            countSmall++;
        }

        // Try each possible i1
        for (int i1 = 1; i1 <= n - (k - 1); i1++) {

            if (countSmall == needed) {
                result = Math.min(result,
                        (long) nums[0] + nums[i1] + sumSmall);
            }

            if (i1 == n - (k - 1)) break;

            // Remove outgoing element
            int outIdx = i1 + 1;
            if (outIdx <= Math.min(n - 1, i1 + dist)) {
                int v = nums[outIdx];
                if (small.containsKey(v)) {
                    remove(small, v);
                    sumSmall -= v;
                    countSmall--;

                    if (!large.isEmpty()) {
                        int mv = large.firstKey();
                        remove(large, mv);
                        add(small, mv);
                        sumSmall += mv;
                        countSmall++;
                    }
                } else {
                    remove(large, v);
                }
            }

            // Add incoming element
            int inIdx = i1 + dist + 1;
            if (inIdx < n) {
                int v = nums[inIdx];
                add(large, v);

                if (countSmall < needed) {
                    int mv = large.firstKey();
                    remove(large, mv);
                    add(small, mv);
                    sumSmall += mv;
                    countSmall++;
                } else if (!large.isEmpty() && large.firstKey() < small.lastKey()) {
                    int a = large.firstKey();
                    int b = small.lastKey();

                    remove(large, a);
                    remove(small, b);

                    add(large, b);
                    add(small, a);

                    sumSmall += a - b;
                }
            }
        }

        return result;
    }

    private void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.get(val) - 1);
        if (map.get(val) == 0) map.remove(val);
    }
}
