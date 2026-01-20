/*
Problem: Construct the Minimum Bitwise Array I
Problem No: 3314
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Bit Manipulation
- Binary Representation
- Greedy

----------------------------------
Problem Statement:
----------------------------------
You are given an array nums consisting of
prime integers.

You need to construct an array ans such that:
    ans[i] OR (ans[i] + 1) == nums[i]

Additionally:
- ans[i] must be minimum possible
- If no such value exists, set ans[i] = -1

----------------------------------
Observations:
----------------------------------
1. For any integer x:
   x OR (x + 1) always sets all trailing bits to 1.
2. If nums[i] is even:
   - Impossible, because OR of two consecutive
     numbers is always odd.
3. nums[i] must be odd to be valid.
4. To minimize ans[i]:
   - Find the lowest bit that can be flipped
     while keeping the OR intact.

----------------------------------
Approach / Explanation:
----------------------------------
1. If nums[i] is even → ans[i] = -1
2. If nums[i] is odd:
   - Count number of trailing 1s in nums[i]
   - Flip the highest trailing 1 bit
   - This produces the minimum valid ans[i]

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * log(nums[i]))
Space Complexity: O(1) extra space

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

            // Even numbers are impossible
            if ((x & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            // Count trailing 1s
            int cnt = 0;
            int temp = x;
            while ((temp & 1) == 1) {
                cnt++;
                temp >>= 1;
            }

            // Flip the highest trailing 1 bit
            ans[i] = x ^ (1 << (cnt - 1));
        }

        return ans;
    }
}
