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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
     
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        fast = head;
        for(int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        
        int temp = fast.val;
        fast.val = slow.val;
        slow.val = temp;
        
        return head;
    }
}