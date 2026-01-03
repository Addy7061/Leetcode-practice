/*
Problem: Self Dividing Numbers
Problem No: 728
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Math
- Number Theory

----------------------------------
Problem Statement:
----------------------------------
A self-dividing number is a number that is divisible by every digit it contains.
The number must not contain the digit zero.

Given two integers left and right, return a list of all self-dividing numbers
in the range [left, right] (inclusive).

----------------------------------
Approach / Explanation:
----------------------------------
1. Iterate through all numbers from left to right.
2. For each number, check whether it is self-dividing.
3. Extract each digit of the number.
4. If any digit is zero or the number is not divisible by that digit,
   it is not a self-dividing number.
5. Add valid numbers to the result list.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * d)
Space Complexity: O(1)  (excluding output list)

where:
n = range size (right - left + 1)  
d = number of digits in a number  

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private boolean isSelfDividing(int num) {
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;

            if (digit == 0 || num % digit != 0) {
                return false;
            }

            temp /= 10;
        }

        return true;
    }
}
