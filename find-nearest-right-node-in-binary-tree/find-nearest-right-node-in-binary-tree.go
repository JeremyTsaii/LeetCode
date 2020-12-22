/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findNearestRightNode(root *TreeNode, u *TreeNode) *TreeNode {
    q := make([]*TreeNode, 0)
    q = append(q, root)
    
    for len(q) != 0 {
        level_len := len(q)
        
        for i := range q {
            node := q[0]
            q = q[1:]
            
            if node == u {
                if i != level_len - 1 {
                    return q[0]
                }
                return nil
            }
            if node.Left != nil {
                q = append(q, node.Left)
            }
            if node.Right != nil {
                q = append(q, node.Right)
            }
        }
    }
    return nil
}
