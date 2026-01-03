/*
Problem: 3Sum
Problem No: 15
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
Given an integer array nums, return all the unique triplets
[nums[i], nums[j], nums[k]] such that:

i != j, i != k, and j != k  
nums[i] + nums[j] + nums[k] == 0

The solution set must not contain duplicate triplets.

----------------------------------
Approach / Explanation:
----------------------------------
1. Sort the array to handle duplicates easily.
2. Iterate through the array and fix one element at a time.
3. Use two pointers (left and right) to find pairs that sum to zero.
4. Skip duplicate elements to avoid repeated triplets.
5. Store valid triplets in the result list.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n²)
Space Complexity: O(1)  (excluding output list)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate second and third elements
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } 
                else if (sum < 0) {
                    left++;
                } 
                else {
                    right--;
                }
            }
        }

        return result;
    }
}
