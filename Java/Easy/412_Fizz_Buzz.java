/*
Problem: Fizz Buzz
Problem No: 412
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Math
- Simulation

----------------------------------
Problem Statement:
----------------------------------
Given an integer n, return a string array answer (1-indexed) where:

- answer[i] = "FizzBuzz" if i is divisible by both 3 and 5
- answer[i] = "Fizz" if i is divisible by 3
- answer[i] = "Buzz" if i is divisible by 5
- answer[i] = i (as a string) otherwise

----------------------------------
Approach / Explanation:
----------------------------------
1. Iterate from 1 to n.
2. Check divisibility by both 3 and 5 first.
3. Then check divisibility by 3 and 5 individually.
4. If none of the conditions match, add the number as a string.
5. Store all results in a list and return it.

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
    public List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}
