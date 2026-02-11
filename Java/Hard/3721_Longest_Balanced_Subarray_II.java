/*
Problem: Longest Balanced Subarray II
Problem No: 3721
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Array
- Sliding Window
- Segment Tree
- Prefix Technique
- Lazy Propagation

------------------------------------------------
Problem Statement:
------------------------------------------------
You are given an integer array nums.

A subarray is called balanced if the number of 
distinct even numbers is equal to the number of 
distinct odd numbers in that subarray.

Return the length of the longest balanced subarray.

------------------------------------------------
Key Observation:
------------------------------------------------
- We must track DISTINCT values (not frequency).
- Even contributes -1
- Odd contributes +1
- Balanced means total contribution = 0
- We use:
  1. Occurrence tracking for each value
  2. Segment Tree to maintain prefix contribution
  3. Lazy propagation for efficient range updates
  4. Sliding left pointer

------------------------------------------------
Approach:
------------------------------------------------
1. Store positions of each distinct value.
2. For first occurrence of each value:
   - Apply +1 (odd) or -1 (even) to suffix.
3. Use segment tree to:
   - Maintain min & max in range
   - Find rightmost index where prefix sum == 0
4. Slide left pointer and update tree accordingly.
5. Track maximum valid length.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n log n)
Space Complexity: O(n)

------------------------------------------------
Solution:
------------------------------------------------
*/
class Solution {

    public int longestBalanced(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        Map<Integer, ArrayList<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        Map<Integer, Integer> currentIndex = new HashMap<>();
        SegmentTree seg = new SegmentTree(n);

        for (int val : positions.keySet()) {
            int sign = (val % 2 == 0) ? -1 : 1;
            int firstPos = positions.get(val).get(0);
            seg.update(firstPos, n - 1, sign);
            currentIndex.put(val, 0);
        }

        int maxLength = 0;

        for (int l = 0; l < n; l++) {

            int r = seg.queryRightmostZero();
            if (r >= l) {
                maxLength = Math.max(maxLength, r - l + 1);
            }

            int val = nums[l];
            int sign = (val % 2 == 0) ? -1 : 1;
            int idx = currentIndex.get(val);
            int currentPos = positions.get(val).get(idx);

            if (currentPos == l) {
                int nextPos = (idx + 1 < positions.get(val).size())
                        ? positions.get(val).get(idx + 1)
                        : n;

                seg.update(0, nextPos - 1, -sign);
                currentIndex.put(val, idx + 1);
            }
        }

        return maxLength;
    }

    // ---------------- Segment Tree ----------------

    class SegmentTree {

        int n;
        int[] min;
        int[] max;
        int[] lazy;

        SegmentTree(int n) {
            this.n = n;
            min = new int[4 * n];
            max = new int[4 * n];
            lazy = new int[4 * n];
        }

        void push(int node) {
            if (lazy[node] != 0) {

                min[node * 2] += lazy[node];
                max[node * 2] += lazy[node];
                lazy[node * 2] += lazy[node];

                min[node * 2 + 1] += lazy[node];
                max[node * 2 + 1] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];

                lazy[node] = 0;
            }
        }

        void update(int l, int r, int val) {
            if (l > r) return;
            update(1, 0, n - 1, l, r, val);
        }

        void update(int node, int tl, int tr, int l, int r, int val) {

            if (l > tr || r < tl) return;

            if (l <= tl && tr <= r) {
                min[node] += val;
                max[node] += val;
                lazy[node] += val;
                return;
            }

            push(node);
            int tm = (tl + tr) / 2;

            update(node * 2, tl, tm, l, r, val);
            update(node * 2 + 1, tm + 1, tr, l, r, val);

            min[node] = Math.min(min[node * 2], min[node * 2 + 1]);
            max[node] = Math.max(max[node * 2], max[node * 2 + 1]);
        }

        int queryRightmostZero() {
            if (min[1] > 0 || max[1] < 0) return -1;
            return queryRightmostZero(1, 0, n - 1);
        }

        int queryRightmostZero(int node, int tl, int tr) {

            if (tl == tr) {
                return min[node] == 0 ? tl : -1;
            }

            push(node);
            int tm = (tl + tr) / 2;

            if (min[node * 2 + 1] <= 0 && max[node * 2 + 1] >= 0) {
                int right = queryRightmostZero(node * 2 + 1, tm + 1, tr);
                if (right != -1) return right;
            }

            if (min[node * 2] <= 0 && max[node * 2] >= 0) {
                return queryRightmostZero(node * 2, tl, tm);
            }

            return -1;
        }
    }
}
