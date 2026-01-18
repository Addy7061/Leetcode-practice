/*
Problem: Merge Intervals
Problem No: 56
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Sorting
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given an array of intervals where
intervals[i] = [start_i, end_i].

Merge all overlapping intervals and return
an array of non-overlapping intervals that
cover all the intervals in the input.

----------------------------------
Approach / Explanation:
----------------------------------
1. Sort all intervals based on their start time.
2. Initialize a list to store merged intervals.
3. Traverse the sorted intervals:
   - If the current interval overlaps with the
     last merged interval, merge them.
   - Otherwise, add the current interval as a new one.
4. Convert the list into a 2D array and return it.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n)  // sorting
Space Complexity: O(n)       // output list

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][0];

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlapping interval
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // Non-overlapping interval
            else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add last interval
        merged.add(new int[]{start, end});

        return merged.toArray(new int[merged.size()][]);
    }
}
