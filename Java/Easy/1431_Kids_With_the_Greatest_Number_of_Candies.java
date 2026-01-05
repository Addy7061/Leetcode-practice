/*
Problem: Kids With the Greatest Number of Candies
Problem No: 1431
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Simulation

----------------------------------
Problem Statement:
----------------------------------
There are n kids with candies. You are given an integer array candies,
where candies[i] represents the number of candies the ith kid has, and
an integer extraCandies.

Return a boolean array result where result[i] is true if, after giving
the ith kid all the extraCandies, they will have the greatest number of
candies among all kids, or false otherwise.

----------------------------------
Approach / Explanation:
----------------------------------
1. Find the maximum number of candies any kid currently has.
2. For each kid, check if candies[i] + extraCandies is greater than or
   equal to the maximum.
3. Add true or false to the result list accordingly.
4. Return the result list.

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
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> result = new ArrayList<>();

        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }

        for (int c : candies) {
            result.add(c + extraCandies >= max);
        }

        return result;
    }
}
