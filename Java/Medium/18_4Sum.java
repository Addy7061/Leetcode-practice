/*
Problem: 4Sum
Problem No: 18
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Array
- Two Pointers
- Sorting

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums and an integer target, return all the unique
quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

a, b, c, d are distinct indices  
nums[a] + nums[b] + nums[c] + nums[d] == target  

The solution set must not contain duplicate quadruplets.

----------------------------------
Approach / Explanation:
----------------------------------
1. Sort the array to easily handle duplicates.
2. Fix the first two elements using nested loops.
3. Use two pointers to find the remaining two elements.
4. Skip duplicate values to avoid repeated quadruplets.
5. Use long for sum calculation to avoid integer overflow.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n³)
Space Complexity: O(1)  (excluding output list)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second elements
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for third and fourth elements
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } 
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
