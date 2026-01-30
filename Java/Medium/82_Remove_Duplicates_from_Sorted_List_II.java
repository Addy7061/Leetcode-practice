/*
Problem: Remove Duplicates from Sorted List II
Problem No: 82
Platform: LeetCode
Difficulty: Medium
Language: Java

Topics:
- Linked List
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given the head of a sorted linked list, delete all nodes that have
duplicate numbers, leaving only distinct numbers from the original list.

The final linked list should also be sorted.

----------------------------------
Approach / Explanation:
----------------------------------
Key Idea:
- Since the list is sorted, duplicates will always appear consecutively.
- If a value appears more than once, all its nodes must be removed.

Steps:
1. Use a dummy node before head to handle edge cases
   (like duplicates at the beginning).
2. Maintain two pointers:
   - `prev`: last node confirmed to be unique
   - `curr`: current node being checked
3. If duplicates are detected:
   - Skip all nodes with the same value
   - Connect `prev.next` to the node after duplicates
4. If no duplicate:
   - Move `prev` normally
5. Continue until end of list.

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
    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            boolean isDuplicate = false;

            // Check for duplicates
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                isDuplicate = true;
            }

            if (isDuplicate) {
                // Skip all duplicate nodes
                prev.next = curr.next;
            } else {
                // Current node is unique
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
