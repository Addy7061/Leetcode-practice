/*
Problem: Balance a Binary Search Tree
Problem No: 1382
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Search Tree
- Tree
- Depth-First Search (DFS)
- Divide and Conquer

------------------------------------------------
Problem Statement:
------------------------------------------------
Given the root of a Binary Search Tree (BST),
return a balanced Binary Search Tree with the same node values.

A BST is balanced if for every node,
the height difference between its left and right subtree
is at most 1.

------------------------------------------------
Key Observation:
------------------------------------------------
- Inorder traversal of a BST gives a sorted list.
- A balanced BST can be built from a sorted array
  by choosing the middle element as root recursively.

------------------------------------------------
Approach:
------------------------------------------------
1. Perform inorder traversal of the BST
   and store node values in a list (sorted order).
2. Use divide & conquer to build a balanced BST:
   - Pick middle element as root.
   - Recursively build left and right subtrees.

------------------------------------------------
Time & Space Complexity:
------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(n)
(for storing inorder traversal + recursion stack)

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

    private List<Integer> values = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        // Step 1: Store inorder traversal (sorted values)
        inorder(root);

        // Step 2: Build balanced BST from sorted list
        return buildBST(0, values.size() - 1);
    }

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }

    private TreeNode buildBST(int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(values.get(mid));

        root.left = buildBST(left, mid - 1);
        root.right = buildBST(mid + 1, right);

        return root;
    }
}
