/*
Problem: Permutation Sequence
Problem No: 60
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Math
- Greedy
- Factorial Number System

----------------------------------
Problem Statement:
----------------------------------
The set [1, 2, 3, ..., n] contains a total
of n! unique permutations.

Given n and k, return the k-th permutation
sequence in lexicographical order.

----------------------------------
Approach / Explanation:
----------------------------------
1. Precompute factorials from 0! to n!.
2. Store numbers from 1 to n in a list.
3. Convert k to 0-based index (k--).
4. For each position:
   - Determine which number should be placed
     using k / factorial.
   - Remove the chosen number from the list.
   - Update k using k % factorial.
5. Build the result step-by-step.

This avoids generating all permutations
and runs efficiently.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n²)
Space Complexity: O(n)

----------------------------------
Solution:
----------------------------------
*/
class Solution {

    public String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        // Precompute factorials and numbers list
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        // Convert k to 0-based index
        k--;

        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }

        return result.toString();
    }
}
