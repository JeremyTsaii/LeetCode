import "sort"
​
func numRescueBoats(people []int, limit int) int {
    sort.Ints(people)
    total := 0
    left, right := 0, len(people) - 1
    
    for left <= right {
        total += 1
        if people[left] + people[right] <= limit {
            left += 1
        }
        right -= 1
    }
    
    return total
}
