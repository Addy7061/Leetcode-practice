/*
Problem: Find Smallest Letter Greater Than Target
Problem No: 744
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Binary Search
- Array

----------------------------------
Problem Statement:
----------------------------------
You are given a sorted array of characters `letters` and a character `target`.

Return the smallest character in `letters` that is lexicographically
greater than `target`.

If no such character exists, return the first character in the array
(wrap-around case).

----------------------------------
Approach / Explanation:
----------------------------------
Key Idea:
- Since the array is sorted, we can use Binary Search.
- We want the **first character strictly greater than target**.

Steps:
1. Perform binary search on `letters`.
2. If `letters[mid] <= target`, move to the right half.
3. Otherwise, move to the left half.
4. After binary search ends:
   - `low` will point to the correct index.
5. Use modulo (`low % letters.length`) to handle wrap-around case.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(log n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0, high = letters.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (letters[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Wrap-around case handled using modulo
        return letters[low % letters.length];
    }
}
