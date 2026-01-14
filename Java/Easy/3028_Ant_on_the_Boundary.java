/*
Problem: Ant on the Boundary
Problem No: 3028
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Simulation
- Prefix Sum

----------------------------------
Problem Statement:
----------------------------------
An ant starts on a boundary at position 0.

You are given an array of non-zero integers nums.
The ant moves step by step according to nums:

- If nums[i] > 0 → move right by nums[i]
- If nums[i] < 0 → move left by -nums[i]

The space is infinite on both sides.

Count how many times the ant returns exactly to the boundary (position 0).
Crossing the boundary during movement does NOT count.
Only final positions after each move are checked.

----------------------------------
Approach / Explanation:
----------------------------------
1. Maintain a variable `position` initialized to 0.
2. Traverse through the nums array:
   - Add nums[i] to position.
3. After each move:
   - If position becomes exactly 0, increment count.
4. Return the total count.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int returnToBoundaryCount(int[] nums) {

        int position = 0;
        int count = 0;

        for (int move : nums) {
            position += move;

            if (position == 0) {
                count++;
            }
        }

        return count;
    }
}
