/*
Problem: Swap Nodes in Pairs
Problem No: 24
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Linked List
- Iteration

----------------------------------
Problem Statement:
----------------------------------
Given a linked list, swap every two adjacent nodes and return its head.
You must solve the problem without modifying the values in the list's
nodes (only nodes themselves may be changed).

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a dummy node to simplify edge cases.
2. Maintain a pointer (prev) that tracks the node before the pair.
3. For each pair of nodes:
   - Swap the two adjacent nodes by re-linking pointers.
4. Move the prev pointer forward by two nodes.
5. Continue until no more pairs can be swapped.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(n)
Space Complexity: O(1)

----------------------------------
Solution:
----------------------------------
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev pointer forward
            prev = first;
        }

        return dummy.next;
    }
}
