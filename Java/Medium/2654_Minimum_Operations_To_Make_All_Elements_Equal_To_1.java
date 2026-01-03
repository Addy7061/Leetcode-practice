/*
Problem: Minimum Number of Operations to Make All Array Elements Equal to 1
Problem No: 2654
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Math
- GCD
- Array

----------------------------------
Problem Statement:
----------------------------------
You are given a 0-indexed array nums of positive integers.

In one operation, you can select an index i (0 <= i < n - 1) and replace
either nums[i] or nums[i + 1] with the gcd of the two numbers.

Return the minimum number of operations required to make all elements
of the array equal to 1. If it is impossible, return -1.

----------------------------------
Approach / Explanation:
----------------------------------
1. Count how many elements are already equal to 1.
2. If at least one 1 exists, all other elements can be converted to 1
   in (n - numberOfOnes) operations.
3. If no 1 exists, find the smallest subarray whose gcd is 1.
4. If no such subarray exists, return -1.
5. Otherwise:
   - (length - 1) operations are needed to create the first 1.
   - (n - 1) operations are needed to convert the rest to 1.
6. Return the total operations.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n²)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int minOperations(int[] nums) {

        int n = nums.length;

        // Count how many 1s already exist
        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }

        // If there are already 1s, just convert others to 1
        if (ones > 0) {
            return n - ones;
        }

        // Find the smallest subarray with gcd = 1
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        // If no subarray has gcd 1, impossible
        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }

        // (minLen - 1) operations to create first 1
        // (n - 1) operations to convert all to 1
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
