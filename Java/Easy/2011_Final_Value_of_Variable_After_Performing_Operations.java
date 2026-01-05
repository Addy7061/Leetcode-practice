/*
Problem: Final Value of Variable After Performing Operations
Problem No: 2011
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Array
- String
- Simulation

----------------------------------
Problem Statement:
----------------------------------
There is a variable X initially set to 0.

You are given an array of strings operations, where each operation is one of:
"++X", "X++", "--X", or "X--".

"++X" and "X++" increment X by 1.  
"--X" and "X--" decrement X by 1.

Return the final value of X after performing all operations.

----------------------------------
Approach / Explanation:
----------------------------------
1. Initialize X = 0.
2. Traverse the operations array.
3. If the middle character of the operation is '+', increment X.
4. Otherwise, decrement X.
5. Return the final value of X.

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
    public int finalValueAfterOperations(String[] operations) {

        int x = 0;

        for (String op : operations) {
            if (op.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}
