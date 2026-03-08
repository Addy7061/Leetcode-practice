/*
Problem: Find Unique Binary String
Problem No: 1980
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- String
- Hashing
- Cantor Diagonalization

----------------------------------
Problem Statement:
----------------------------------
You are given n unique binary strings of length n.

Return any binary string of length n that
does NOT appear in the given array.

----------------------------------
Key Idea (Cantor Diagonal Trick):
----------------------------------
Construct a new string by flipping the i-th bit
of the i-th string.

Example:

nums = ["01","10"]

i=0 → nums[0][0] = '0' → flip → '1'
i=1 → nums[1][1] = '0' → flip → '1'

Result → "11"

This guarantees the new string differs from every
string at least at one position.

----------------------------------
Why It Works:
----------------------------------
The new string differs from:
nums[0] at index 0
nums[1] at index 1
nums[2] at index 2
...

So it cannot match any existing string.

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

    public String findDifferentBinaryString(String[] nums) {

        int n = nums.length;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {

            if (nums[i].charAt(i) == '0')
                result.append('1');
            else
                result.append('0');
        }

        return result.toString();
    }
}
