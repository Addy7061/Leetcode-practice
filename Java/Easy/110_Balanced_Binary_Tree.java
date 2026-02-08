/*
Problem: Balanced Binary Tree
Problem No: 110
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Tree
- Depth-First Search (DFS)
- Binary Tree

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a binary tree, determine if it is height-balanced.

A binary tree is height-balanced if:
- The left and right subtrees of every node differ in height by no more than 1.

------------------------------------------------
Key Observation:
------------------------------------------------
- Height balance must be checked at EVERY node.
- A bottom-up DFS approach is efficient.
- If any subtree is unbalanced, we propagate a failure signal upward.

------------------------------------------------
Approach:
------------------------------------------------
1. Use a recursive height function.
2. For each node:
   - Compute left subtree height.
   - Compute right subtree height.
3. If the absolute difference > 1 → tree is unbalanced.
4. Return -1 immediately if unbalanced to stop further computation.
5. If root height != -1 → tree is balanced.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(h)
where h is the height of the tree (recursion stack)

------------------------------------------------
Solution:
------------------------------------------------
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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
