/*
Problem: Reverse Nodes in k-Group
Problem No: 25
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Linked List
- Pointer Manipulation

----------------------------------
Problem Statement:
----------------------------------
Given the head of a linked list, reverse the nodes of the list k at a time
and return the modified list.

If the number of nodes is not a multiple of k, the remaining nodes
should remain as they are.

You may not modify the values in the list nodes, only the node links.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a dummy node to simplify edge cases.
2. For each group of k nodes:
   - Find the k-th node.
   - Reverse the nodes in the group using pointer manipulation.
3. Connect the reversed group with the previous part of the list.
4. Repeat until fewer than k nodes remain.

This solution works in-place using constant extra space.

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
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break;

            ListNode groupNext = kth.next;
            ListNode prev = groupNext;
            ListNode curr = prevGroupEnd.next;

            // Reverse current group
            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect with previous group
            ListNode temp = prevGroupEnd.next;
            prevGroupEnd.next = kth;
            prevGroupEnd = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
