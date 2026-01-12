/*
Problem: Keep Multiplying Found Values by Two
Problem No: 2154
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Simulation
- Greedy

----------------------------------
Problem Statement:
----------------------------------
Given an array nums and an integer original, keep checking
whether original exists in nums.

If found, multiply original by 2 and repeat.
Stop when original is not found and return the final value.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a loop to repeatedly scan the array.
2. Check if original exists in nums.
3. If found, multiply original by 2.
4. If not found, stop the process.
5. Return original.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * k)
(where k is the number of times original is found)

Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int findFinalValue(int[] nums, int original) {

        boolean found = true;

        while (found) {
            found = false;

            for (int num : nums) {
                if (num == original) {
                    original *= 2;
                    found = true;
                    break;
                }
            }
        }

        return original;
    }
}
