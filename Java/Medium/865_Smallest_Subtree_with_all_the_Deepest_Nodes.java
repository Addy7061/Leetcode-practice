/*
Problem: Smallest Subtree with all the Deepest Nodes
Problem No: 865
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Tree
- Depth-First Search (DFS)

----------------------------------
Problem Statement:
----------------------------------
Given the root of a binary tree, return the smallest subtree that contains
all the deepest nodes in the original tree.

The depth of a node is the shortest distance to the root.
Deepest nodes are those with the maximum depth.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use DFS to compute depth of left and right subtrees.
2. For each node, compare depths of its left and right subtrees:
   - If left depth > right depth → deepest nodes are in left subtree.
   - If right depth > left depth → deepest nodes are in right subtree.
   - If both depths are equal → current node is the smallest subtree
     containing all deepest nodes.
3. Return both the node and its depth using a helper Pair class.

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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode node) {
        if (node == null) {
            return new Pair(null, 0);
        }

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }
        if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
        }

        // Both depths are equal
        return new Pair(node, left.depth + 1);
    }

    // Helper class to store node and depth
    private static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
