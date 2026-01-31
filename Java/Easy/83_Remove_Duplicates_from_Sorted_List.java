/*
Problem: Remove Duplicates from Sorted List
Problem No: 83
Platform: LeetCode
Difficulty: Easy
Language: Java

Topics:
- Linked List
- Two Pointers

----------------------------------
Problem Statement:
----------------------------------
Given the head of a sorted linked list, delete all duplicates such that
each element appears only once.

Return the linked list sorted as well.

----------------------------------
Approach / Explanation:
----------------------------------
Key Idea:
- Since the list is already sorted, duplicates will always be adjacent.
- Traverse the list once and compare current node with next node.

Steps:
1. Start from the head node.
2. While current node and next node exist:
   - If current value equals next value, skip the next node.
   - Otherwise, move forward normally.
3. Return the modified head.

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

        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip duplicate
            } else {
                curr = curr.next; // move forward
            }
        }

        return head;
    }
}
