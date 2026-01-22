/*
Problem: Minimum Pair Removal to Sort Array I
Problem No: 3507
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Arrays
- Simulation
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given an integer array nums.

Operation:
- Select the adjacent pair with the minimum sum.
- If multiple such pairs exist, choose the leftmost one.
- Replace the pair with their sum.

Return the minimum number of operations needed to make
the array non-decreasing.

----------------------------------
Approach / Explanation:
----------------------------------
1. If the array is already non-decreasing, return 0.
2. Otherwise, repeat:
   - Find the adjacent pair with the minimum sum
     (choose leftmost in case of tie).
   - Replace that pair with their sum.
   - Count one operation.
3. Continue until the array becomes non-decreasing.
4. Return the total operations.

Since array size is small (≤ 50), simulation is sufficient.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n³) in worst case
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/

class Solution {

    public int minimumPairRemoval(int[] nums) {
        int operations = 0;

        while (!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;

            // find leftmost adjacent pair with minimum sum
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // build new array after merging the pair
            int[] next = new int[nums.length - 1];
            int k = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    next[k++] = nums[i] + nums[i + 1];
                    i++; // skip the merged element
                } else {
                    next[k++] = nums[i];
                }
            }

            nums = next;
            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
