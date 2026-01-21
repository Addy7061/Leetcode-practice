/*
Problem: Construct the Minimum Bitwise Array II
Problem No: 3315
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Bit Manipulation
- Greedy
- Binary Representation

----------------------------------
Problem Statement:
----------------------------------
You are given an array nums consisting of prime integers.

You need to construct an array ans such that:
ans[i] OR (ans[i] + 1) == nums[i]

Additionally:
- ans[i] should be minimum possible
- If no such ans[i] exists, set ans[i] = -1

----------------------------------
Key Observations:
----------------------------------
1. If nums[i] is even:
   - Impossible, because (a | (a+1)) is always odd
2. nums[i] is prime and odd:
   - Valid solution exists
3. For any odd number x:
   - Let x end with k trailing 1s in binary
   - The minimum a is obtained by turning off
     the highest trailing 1-bit

----------------------------------
Approach / Explanation:
----------------------------------
For each number x in nums:
1. If x is even → ans = -1
2. Otherwise:
   - Count number of trailing 1s in x
   - Subtract 2^(count - 1) from x
   - This gives the minimum valid ans[i]

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * log(max(nums[i])))
Space Complexity: O(1) (excluding output array)

----------------------------------
Solution:
----------------------------------
*/
class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {

        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            // Even number => impossible
            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // Count trailing 1s
            int temp = x;
            int count = 0;
            while ((temp & 1) == 1) {
                count++;
                temp >>= 1;
            }

            // Minimum possible value of ans[i]
            ans[i] = x - (1 << (count - 1));
        }

        return ans;
    }
}
