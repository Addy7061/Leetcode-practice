/*
Problem: N-Repeated Element in Size 2N Array
Problem No: 961
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Hash Table
- Array

----------------------------------
Problem Statement:
----------------------------------
You are given an integer array nums such that:
- nums.length == 2 * n
- nums contains n + 1 unique elements
- Exactly one element is repeated n times

Return the element that is repeated n times.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a HashSet to keep track of elements seen so far.
2. Traverse the array:
   - Try to add each element to the set.
   - If adding fails, it means the element is already present.
3. Return the repeated element immediately.
4. This works because exactly one element is repeated n times.

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
    public int repeatedNTimes(int[] nums) {

        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return num;
            }
        }

        return -1; // unreachable as per problem constraints
    }
}
