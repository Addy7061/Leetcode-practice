/*
Problem: Merge k Sorted Lists
Problem No: 23
Platform: LeetCode
Difficulty: Hard
Language: Java

Topics:
- Linked List
- Heap (Priority Queue)
- Divide and Conquer

----------------------------------
Problem Statement:
----------------------------------
You are given an array of k sorted linked lists.
Merge all the linked lists into one sorted linked list
and return it.

----------------------------------
Approach / Explanation:
----------------------------------
1. Use a Min-Heap (PriorityQueue) to always get the smallest node.
2. Insert the head of each non-empty linked list into the heap.
3. Repeatedly extract the minimum node and add it to the result list.
4. If the extracted node has a next node, insert it into the heap.
5. Continue until the heap becomes empty.

This ensures we always merge nodes in sorted order efficiently.

----------------------------------
Time & Space Complexity:
----------------------------------
Time Complexity: O(N log k)
Space Complexity: O(k)

(where N is the total number of nodes and k is the number of lists)

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
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add the head of each list to the priority queue
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
