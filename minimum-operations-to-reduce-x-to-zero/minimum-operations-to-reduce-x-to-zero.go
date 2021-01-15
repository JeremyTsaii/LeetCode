func minOperations(nums []int, x int) int {
    sum := 0
    for _, num := range nums {
        sum += num
    }
    k := sum - x
    total, max := 0, -1
    m := map[int]int{0:-1}
    
    for i, num := range nums {
        total += num
        if _, found := m[total]; !found {
            m[total] = i
        }
        if j, found := m[total - k]; found && i - j > max {
            max = i - j
        }
    }
    
    if max != -1 {
        max = len(nums) - max
    }
    return max
}
