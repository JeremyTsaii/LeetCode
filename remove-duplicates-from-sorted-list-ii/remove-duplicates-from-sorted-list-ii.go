/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    
    prev := &ListNode{101, nil}
    cur := head
    dup := false
    
    for cur.Next != nil {
        if cur.Val == cur.Next.Val {
            dup = true
            cur.Next = cur.Next.Next
        } else {
            if dup {
                dup = false
                if prev.Val != 101 {
                    prev.Next = cur.Next
                } else {
                    head = cur.Next
                }
                cur = cur.Next
            } else {
                prev = cur
                cur = cur.Next
            }
        }
    }
    
    if dup {
        if prev.Val != 101 {
            prev.Next = nil
        } else {
            return nil
        }
    }
    return head
}
