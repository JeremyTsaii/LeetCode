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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode anchor = head;
        for (int i = 0; i < n; i++) {
            anchor = anchor.next;
        }
        
        ListNode cur = head;
        while(anchor !=  null && anchor.next != null) {
            anchor = anchor.next;
            cur = cur.next;
        }
        
        if (anchor == null) {
            return cur.next;
        }
        
        cur.next = cur.next.next;
        
        return head;
    }
}