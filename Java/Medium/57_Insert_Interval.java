/*
Problem: Insert Interval
Problem No: 57
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Arrays
- Intervals
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given a list of non-overlapping
intervals sorted by start time.

Insert a new interval into the list such
that the resulting list is still sorted
and contains no overlapping intervals.

Merge intervals if necessary.

----------------------------------
Approach / Explanation:
----------------------------------
1. Traverse intervals and add all intervals
   that end before the new interval starts.
2. Merge all intervals that overlap with
   the new interval:
      - Update start = min(starts)
      - Update end = max(ends)
3. Add the merged new interval.
4. Add all remaining intervals.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Step 3: Add remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
