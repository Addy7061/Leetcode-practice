/*
Problem: First Missing Positive
Problem No: 41
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Array
- In-place Hashing
- Index Mapping

----------------------------------
Problem Statement:
----------------------------------
Given an unsorted integer array `nums`,
return the smallest positive integer that is missing.

Constraints:
- Must run in O(n) time
- Must use O(1) extra space

----------------------------------
Approach / Explanation:
----------------------------------
Key Observation:
The smallest missing positive number must be in the range [1, n+1],
where n = length of array.

Steps:
1. Iterate through the array and place each number `x`
   at index `x - 1` (if 1 ≤ x ≤ n).
2. Use swapping to position numbers correctly.
3. Ignore:
   - Negative numbers
   - Zero
   - Numbers greater than n
4. After rearrangement:
   - Traverse the array again.
   - The first index `i` where nums[i] != i + 1
     gives the missing positive number.
5. If all numbers are correctly placed, answer is `n + 1`.

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

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number x at index x-1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 &&
                   nums[i] <= n &&
                   nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
