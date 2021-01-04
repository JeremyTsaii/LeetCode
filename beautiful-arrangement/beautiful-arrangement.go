func countArrangement(n int) int {
    count := 0
    backtrack([]int{}, n, &count)
    return count
}
​
func backtrack(path []int, n int, count *int) {
    if len(path) == n {
        *count += 1
        return
    }
    for i := 1; i < n+1; i++ {
        if !numInArr(i, path) && (i % (len(path)+1) == 0 || (len(path)+1) % i == 0) {
            newPath := append(path, i)
            backtrack(newPath, n, count)
        }
    }
}
​
func numInArr(num int, arr []int) bool {
    for _, val := range arr {
        if val == num {
            return true
        }
    }
    return false
}
