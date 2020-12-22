import (
    "fmt"
)
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func plusOne(head *ListNode) *ListNode {
    m := make(map[*ListNode]*ListNode)
    
    cur := head
    for cur.Next != nil {
        m[cur.Next] = cur
        cur = cur.Next
    }
    
    carry := 1
    for carry != 0 {
        carry = 0
        cur.Val += 1
        carry = cur.Val / 10
        cur.Val %= 10
        
        prev, found := m[cur]
        if !found && carry == 1 {
            newHead := &ListNode{1, head}
            return newHead
        }
        cur = prev
    }
    return head
}
