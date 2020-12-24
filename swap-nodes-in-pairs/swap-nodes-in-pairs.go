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
func swapPairs(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    arr := []*ListNode{}
    
    cur := head
    for cur != nil {
        arr = append(arr, cur)
        next := cur.Next
        cur.Next = nil
        cur = next
    }
    
    for i := 1; i < len(arr); i+=2 {
        arr[i], arr[i-1] = arr[i-1], arr[i]
    }
    
    for i := 0; i < len(arr)-1; i+=1 {
        arr[i].Next = arr[i+1]
    }
    
    return arr[0]
}
