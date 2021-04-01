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
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode cur = head;
        
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        
        if (len <= 1) {
            return true;
        }
        
        ListNode split = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            split = split.next;
        }
        
        ListNode head2 = split.next;
        if (len % 2 == 1) {
            head2 = head2.next;
        }
        split.next = null;
        ListNode head1 = reverse(head);
        
        while(head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, next = head.next;
        
        while(next != null) {
            ListNode temp = next.next;
            cur.next = prev;
            next.next = cur;
            
            prev = cur;
            cur = next;
            next = temp;
        }
        
        return cur;
    }
}