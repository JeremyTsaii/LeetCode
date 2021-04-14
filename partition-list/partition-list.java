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
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        List<Integer> less = new ArrayList<>();
        List<Integer> other = new ArrayList<>();
        
        while(cur != null) {
            if (cur.val < x) {
                less.add(cur.val);
            } else {
                other.add(cur.val);
            }
            cur = cur.next;
        }

        cur = head;
        for (int num : less) {
            cur.val = num;
            cur = cur.next;
        }
        for (int num : other) {
            cur.val = num;
            cur = cur.next;
        }
        
        return head;
    }
}