/*
Problem: Can Make Arithmetic Progression From Sequence
Problem No: 1502
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Sorting

----------------------------------
Problem Statement:
----------------------------------
A sequence of numbers is called an arithmetic progression if the difference
between any two consecutive elements is the same.

Given an array arr, return true if the array can be rearranged to form
an arithmetic progression. Otherwise, return false.

----------------------------------
Approach / Explanation:
----------------------------------
1. Sort the array to arrange elements in order.
2. Calculate the difference between the first two elements.
3. Traverse the array and check if the difference between every
   consecutive pair is the same.
4. If any difference mismatches, return false.
5. Otherwise, return true.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n log n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);
        int diff = arr[1] - arr[0];

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}
