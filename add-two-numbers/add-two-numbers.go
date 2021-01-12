/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    dummy := &ListNode{0, nil}
    cur := dummy
    carry := 0
    for l1 != nil || l2 != nil {
        l1Val := 0
        l2Val := 0
        if l1 != nil {
            l1Val = (*l1).Val
            l1 = (*l1).Next
        }
        if l2 != nil {
            l2Val = (*l2).Val
            l2 = (*l2).Next
        }
        val := l1Val + l2Val + carry
        carry = val / 10
        val %= 10
        cur.Next = &ListNode{val, nil}
        
        cur = (*cur).Next
    }
    if carry != 0 {
        cur.Next = &ListNode{1, nil}
    }
    
    return (*dummy).Next
}
