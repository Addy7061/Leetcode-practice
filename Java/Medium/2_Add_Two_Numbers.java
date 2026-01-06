/*
Problem: Add Two Numbers
Problem No: 2
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Linked List
- Math
- Simulation

----------------------------------
Problem Statement:
----------------------------------
You are given two non-empty linked lists representing two non-negative
integers. The digits are stored in reverse order, and each node contains
a single digit.

Add the two numbers and return the sum as a linked list.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a dummy node to simplify linked list construction.
2. Traverse both linked lists simultaneously.
3. Add corresponding digits along with the carry.
4. Store the last digit of the sum in a new node.
5. Update carry for the next iteration.
6. Continue until both lists and carry are exhausted.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))

(where m and n are lengths of the linked lists)

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int total = x + y + carry;
            carry = total / 10;

            current.next = new ListNode(total % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
