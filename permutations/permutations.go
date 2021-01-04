import (
    "fmt"
)
​
func backtrack(path []int, nums []int, output *[][]int) {
    if len(path) == len(nums) {
        *output = append(*output, path)
    }
    for i := 0; i < len(nums); i++ {
        if !numInSlice(nums[i], path) {
            newPath := append(path, nums[i])
            backtrack(newPath, nums, output)
        }
    }
}
​
func numInSlice(num int, arr []int) bool {
    for _, val := range arr {
        if val == num {
            return true
        }
    }
    return false
}
​
func permute(nums []int) [][]int {
    var output = make([][]int, 0)
    backtrack([]int{}, nums, &output)
    return output
}
