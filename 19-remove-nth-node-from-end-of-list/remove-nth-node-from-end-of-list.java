/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Given n will always be valid.
 * Try to do this in one pass.
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, prev = head;
        while(n-- > 0) {
            cur = cur.next;
        }
        if (cur == null) 
            return head.next;
        while (cur.next != null) {
            cur = cur.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}