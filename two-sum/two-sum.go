func twoSum(nums []int, target int) []int {
    m := make(map[int]int)
    for i, _ := range nums {
        if idx, found := m[target - nums[i]]; found {
            return []int{i, idx}
        }
        m[nums[i]] = i
    }
    return []int{}
}
