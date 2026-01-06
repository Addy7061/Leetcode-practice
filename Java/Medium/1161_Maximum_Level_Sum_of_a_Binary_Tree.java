/*
Problem: Maximum Level Sum of a Binary Tree
Problem No: 1161
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Binary Tree
- Breadth-First Search (BFS)
- Queue

----------------------------------
Problem Statement:
----------------------------------
Given the root of a binary tree, the level of its root is 1, the level
of its children is 2, and so on.

Return the smallest level x such that the sum of all node values at
level x is maximum.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use Breadth-First Search (level order traversal).
2. Traverse the tree level by level using a queue.
3. For each level:
   - Calculate the sum of node values.
4. Track the maximum sum and its corresponding level.
5. If multiple levels have the same maximum sum, return the smallest level.

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
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int maxLevel = 1;
        long maxSum = Long.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }
}
