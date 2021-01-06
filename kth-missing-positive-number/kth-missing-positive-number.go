import ("fmt")
​
func findKthPositive(arr []int, k int) int {
    // Cur always greater than or equal to current element of arr
    cur := 1
    for _, num := range arr {
        if num > cur {
            diff := num - cur
            if diff >= k {
                return cur - 1 + k
            }
            k -= diff
        }
        cur = num + 1
    }
    return (cur-1) + k
}
