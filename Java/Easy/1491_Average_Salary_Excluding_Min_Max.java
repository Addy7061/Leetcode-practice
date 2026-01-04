/*
Problem: Average Salary Excluding the Minimum and Maximum Salary
Problem No: 1491
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- Math

----------------------------------
Problem Statement:
----------------------------------
You are given an array of unique integers salary where salary[i]
represents the salary of the ith employee.

Return the average salary of employees excluding the minimum and
maximum salary.

Answers within 10^-5 of the actual answer will be accepted.

----------------------------------
Approach / Explanation:
----------------------------------
1. Traverse the array to find the minimum and maximum salary.
2. Calculate the total sum of all salaries.
3. Subtract the minimum and maximum salary from the total sum.
4. Divide the remaining sum by (n - 2) to get the average.

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
    public double average(int[] salary) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum += s;
        }

        return (double) (sum - min - max) / (salary.length - 2);
    }
}
