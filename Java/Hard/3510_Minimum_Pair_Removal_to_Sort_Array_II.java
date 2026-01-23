/*
Problem: Minimum Pair Removal to Sort Array II
Problem No: 3510
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Priority Queue (Heap)
- Linked List Simulation
- Greedy
- Data Structures

----------------------------------
Problem Statement:
----------------------------------
You are given an array nums.

Operation:
- Select the adjacent pair with the minimum sum.
- If multiple exist, choose the leftmost one.
- Replace the pair with their sum.

Goal:
Return the minimum number of operations required
to make the array non-decreasing.

----------------------------------
Approach / Explanation:
----------------------------------
Key Observations:
- Brute force simulation is too slow for n up to 1e5.
- We must always remove the adjacent pair with the
  minimum sum efficiently.

Steps:
1. Convert nums into a long array for safety.
2. Simulate a doubly linked list using `prev` and `next`.
3. Use a PriorityQueue to store adjacent pair sums.
4. Repeatedly:
   - Check if array is already non-decreasing.
   - Remove the valid minimum-sum adjacent pair.
   - Merge them and update links.
   - Push new adjacent sums into the heap.
5. Count operations until array becomes sorted.

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

    static class Pair {
        long sum;
        int idx;

        Pair(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = nums[i];

        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
            alive[i] = true;
        }
        next[n - 1] = -1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.sum == b.sum ? a.idx - b.idx : Long.compare(a.sum, b.sum)
        );

        // initial adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(arr[i] + arr[i + 1], i));
        }

        int ops = 0;

        while (true) {
            // check if already non-decreasing
            boolean sorted = true;
            for (int i = 0; i != -1 && next[i] != -1; i = next[i]) {
                if (arr[i] > arr[next[i]]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;

            // find valid minimum pair
            Pair p;
            while (true) {
                p = pq.poll();
                int i = p.idx;
                if (i != -1 && alive[i] && next[i] != -1 && alive[next[i]]
                        && arr[i] + arr[next[i]] == p.sum) {
                    break;
                }
            }

            int i = p.idx;
            int j = next[i];

            // merge
            arr[i] += arr[j];
            alive[j] = false;

            next[i] = next[j];
            if (next[j] != -1) prev[next[j]] = i;

            // update heap
            if (prev[i] != -1)
                pq.offer(new Pair(arr[prev[i]] + arr[i], prev[i]));

            if (next[i] != -1)
                pq.offer(new Pair(arr[i] + arr[next[i]], i));

            ops++;
        }

        return ops;
    }
}
