/*
Problem: Add Two Numbers
Problem No: 2
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Linked List
- Math
- Recursion

----------------------------------
Problem Statement:
----------------------------------
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each node contains a single digit.

Add the two numbers and return the sum as a linked list in reverse order.
You may assume the numbers do not contain any leading zeros, except the number 0 itself.

----------------------------------
Approach / Explanation:
----------------------------------
1. Create a dummy node to simplify result list construction.
2. Traverse both linked lists simultaneously.
3. Add corresponding digits along with a carry.
4. Store (sum % 10) in a new node and update carry (sum / 10).
5. Continue until both lists are fully traversed and no carry remains.
6. Return dummy.next as the head of the result list.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(max(m, n))
Space Complexity: O(max(m, n))

----------------------------------
Solution:
----------------------------------
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
