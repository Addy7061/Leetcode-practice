/*
Problem: Sort Integers by The Number of 1 Bits
Problem No: 1356
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Sorting
- Bit Manipulation
- Custom Comparator

------------------------------------------------
Problem Statement:
------------------------------------------------
Sort the array in ascending order based on:
1) Number of 1's in binary representation.
2) If tie → normal ascending order.

------------------------------------------------
Key Idea:
------------------------------------------------
Use Integer.bitCount(x) to count set bits.

Custom Sorting Rule:
- First compare by bit count.
- If equal → compare numbers directly.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n log n)

Space Complexity:
------------------------------------------------
O(n) (for Integer wrapper array)

------------------------------------------------
*/
class Solution {

    public int[] sortByBits(int[] arr) {

        Integer[] temp = new Integer[arr.length];

        // Convert to Integer[] for custom comparator
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {

            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if (bitsA == bitsB)
                return a - b;          // Normal ascending

            return bitsA - bitsB;      // Sort by bit count
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}
