func getMaximumGenerated(n int) int {
    if n == 0 {
        return 0
    }
    arr := make([]int, n + 1)
    arr[1] = 1
    max := 1
    for i := range arr {
        j := i / 2
        if i % 2 == 0 {
            arr[i] = arr[j]
        } else {
            arr[i] = arr[j] + arr[j+1]
        }
        if arr[i] > max {
            max = arr[i]
        }
    }
    
    return max
}
