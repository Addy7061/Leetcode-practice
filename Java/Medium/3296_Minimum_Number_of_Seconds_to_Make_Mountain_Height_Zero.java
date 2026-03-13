/*
Problem: Minimum Number of Seconds to Make Mountain Height Zero
Problem No: 3296
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Search
- Math
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given the height of a mountain and multiple workers.

Each worker i has workerTimes[i].

If a worker reduces the mountain by x height,
the time taken is:

workerTimes[i] * (1 + 2 + 3 + ... + x)

Which equals:

workerTimes[i] * x * (x + 1) / 2

Workers work simultaneously.

Return the minimum number of seconds required
to reduce the mountain height to zero.

----------------------------------
Key Idea:
----------------------------------
We want the minimum time required.

This is a typical **Binary Search on Answer** problem.

For a given time T:
- Calculate how much height each worker can reduce.
- Sum all reductions.
- If total ≥ mountainHeight → T is feasible.

----------------------------------
Worker Contribution:
----------------------------------
For worker with time t:

t * x * (x + 1) / 2 ≤ T

Solve for x using binary search.

----------------------------------
Binary Search Range:
----------------------------------
0 → 1e18

----------------------------------
Time Complexity:
----------------------------------
Binary search on time: log(1e18)

Inside each check:
workers × log(height)

Total ≈ O(n log H log T)

----------------------------------
Space Complexity:
----------------------------------
O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 0;
        long right = (long) 1e18;
        long ans = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private boolean can(long time, int height, int[] workers) {

        long total = 0;

        for (int t : workers) {

            long l = 0, r = (long) 1e6;

            while (l <= r) {

                long m = (l + r) / 2;

                long needed = (long) t * m * (m + 1) / 2;

                if (needed <= time)
                    l = m + 1;
                else
                    r = m - 1;
            }

            total += r;

            if (total >= height)
                return true;
        }

        return total >= height;
    }
}
