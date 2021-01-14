import "fmt"
func maxSubArrayLen(nums []int, k int) int {
    left := make([]int, len(nums) + 1)
    total := 0
    for i, num := range nums {
        total += num
        left[i+1] = total
    }
    
    max := 0
    
    fmt.Println(left)
    
    for i := range nums {
        for j := range nums {
            if left[j+1] - left[i] == k {
                if j - i + 1 > max {
                    max = j - i + 1
                }
            }
        }
    }
    
    return max
}
