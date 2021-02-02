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
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        ListNode prev = sentinel;
        
        ListNode cur = head;
        
        while (cur != null) {
            if (cur.val != val) {
                prev.next = cur;
                prev = cur;
            } else {
                prev.next = cur.next;
            }
            cur = cur.next;
        }
        
        return sentinel.next;
    }
}