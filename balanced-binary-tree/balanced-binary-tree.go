/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func helper(root *TreeNode) int {
    if root == nil {
        return 0
    }
    left := helper(root.Left)
    right := helper(root.Right)
    if Abs(left - right) > 1 || left == -1 || right == -1 {
        return -1
    }
    return 1 + Max(left, right)
}
​
func isBalanced(root *TreeNode) bool {
    return helper(root) != -1
}
​
func Abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}
​
func Max(x int, y int) int {
    if x > y {
        return x
    }
    return y
}
