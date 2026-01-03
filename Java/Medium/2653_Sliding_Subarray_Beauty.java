/*
Problem: Sliding Subarray Beauty
Problem No: 2653
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Sliding Window
- Frequency Array
- Counting

----------------------------------
Problem Statement:
----------------------------------
Given an integer array nums, find the beauty of each subarray of size k.

The beauty of a subarray is defined as the x-th smallest negative integer
in the subarray. If there are fewer than x negative integers, the beauty is 0.

Return an array containing the beauty of each subarray in order.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a sliding window of size k.
2. Maintain a frequency array for numbers in the range [-50, 50].
3. Initialize the frequency array for the first window.
4. For each window:
   - Traverse only negative numbers (-50 to -1).
   - Count frequencies until the x-th negative number is found.
   - If found, store it as beauty; otherwise, store 0.
5. Slide the window by removing the outgoing element and adding the incoming one.
6. Repeat until all windows are processed.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n * 50) ≈ O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Frequency array for values from -50 to 50
        int[] freq = new int[101]; // index = value + 50

        // Initialize first window
        for (int i = 0; i < k; i++) {
            freq[nums[i] + 50]++;
        }

        // Process each window
        for (int i = 0; i <= n - k; i++) {
            int count = 0;
            int beauty = 0;

            // Find x-th smallest negative number
            for (int v = 0; v < 50; v++) { // only negatives (-50 to -1)
                count += freq[v];
                if (count >= x) {
                    beauty = v - 50;
                    break;
                }
            }

            result[i] = beauty;

            // Slide the window
            if (i + k < n) {
                freq[nums[i] + 50]--;       // remove outgoing element
                freq[nums[i + k] + 50]++;   // add incoming element
            }
        }

        return result;
    }
}
