/*
Problem: Rotate List
Problem No: 61
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Linked List
- Two Pointers
- Circular Linked List

----------------------------------
Problem Statement:
----------------------------------
Given the head of a linked list, rotate
the list to the right by k places.

----------------------------------
Approach / Explanation:
----------------------------------
1. Handle edge cases:
   - Empty list
   - Single node
   - k = 0
2. Traverse the list to:
   - Find the length
   - Reach the last node
3. Connect the last node to the head
   to form a circular linked list.
4. Compute effective rotations:
      k = k % length
5. Find the new tail at position:
      (length - k - 1)
6. The node next to new tail is
   the new head.
7. Break the circle and return
   the new head.

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

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find length and last node
        ListNode curr = head;
        int length = 1;

        while (curr.next != null) {
            curr = curr.next;
            length++;
        }

        // Step 2: Make the list circular
        curr.next = head;

        // Step 3: Find new tail
        k = k % length;
        int stepsToNewTail = length - k - 1;

        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Step 4: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
