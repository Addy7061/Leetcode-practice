/*
Problem: Sum of Root To Leaf Binary Numbers
Problem No: 1022
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Tree
- DFS
- Bit Manipulation

------------------------------------------------
Problem Statement:
------------------------------------------------
Given a binary tree where each node contains
0 or 1, every root-to-leaf path forms a binary number.

Return the sum of all root-to-leaf binary numbers.

------------------------------------------------
Key Idea:
------------------------------------------------
Instead of storing the full path as string,
we build the binary number using bit operations.

At each node:
current = (current << 1) | node.val

This shifts previous bits left and adds current bit.

When we reach a leaf:
→ return the built number.

------------------------------------------------
Time Complexity:
------------------------------------------------
O(n)  (visit each node once)

Space Complexity:
------------------------------------------------
O(h)  (recursion stack, h = tree height)

------------------------------------------------
*/

class Solution {

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {

        if (node == null)
            return 0;

        // Shift left and add current bit
        current = (current << 1) | node.val;

        // If leaf node
        if (node.left == null && node.right == null)
            return current;

        // Recur for left and right
        return dfs(node.left, current) +
               dfs(node.right, current);
    }
}
