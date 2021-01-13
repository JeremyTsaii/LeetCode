import "sort"
​
func numRescueBoats(people []int, limit int) int {
    sort.Ints(people)
    total := 1
    capacity := 0
    left, right := 0, len(people) - 1
    num := 0
    
    for left <= right {
        if num < 2 && people[right] + capacity <= limit {
            capacity += people[right]
            num += 1
            right -= 1
        } else if num < 2 && people[left] + capacity <= limit {
            capacity += people[left]
            num += 1
            left += 1
        } else {
            total += 1
            capacity = 0
            num = 0
        }
    }
    
    return total
}
