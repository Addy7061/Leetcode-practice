/*
Problem: Maximum Product of Splitted Binary Tree
Problem No: 1339
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Tree
- Depth-First Search (DFS)
- Tree DP

----------------------------------
Problem Statement:
----------------------------------
Given the root of a binary tree, split the tree into two subtrees
by removing exactly one edge such that the product of the sums
of the two subtrees is maximized.

Return the maximum product modulo (10^9 + 7).
Note: The maximum product should be calculated before taking modulo.

----------------------------------
Approach / Explanation:
----------------------------------
1. First compute the total sum of all nodes in the tree.
2. Perform a DFS traversal to compute the sum of each subtree.
3. For every subtree, consider splitting it from the rest of the tree.
4. Calculate the product:
      subtreeSum * (totalSum - subtreeSum)
5. Track the maximum product during traversal.
6. Return the maximum product modulo (10^9 + 7).

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(n)

(where n is the number of nodes in the tree)

----------------------------------
Solution:
----------------------------------
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        dfs(root);
        return (int) (maxProduct % MOD);
    }

    // Compute total sum of the tree
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    // DFS to compute subtree sums and update max product
    private long dfs(TreeNode node) {
        if (node == null) return 0;

        long left = dfs(node.left);
        long right = dfs(node.right);

        long subSum = left + right + node.val;
        long product = subSum * (totalSum - subSum);
        maxProduct = Math.max(maxProduct, product);

        return subSum;
    }
}
