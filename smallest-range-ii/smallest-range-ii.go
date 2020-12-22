func smallestRangeII(A []int, K int) int {
    sort.Ints(A)
    max := A[len(A)-1]
    min := A[0]
    minDiff := max - min
    for i := 0; i < len(A) - 1; i++ {
        minDiff = Min(minDiff, Max(max - K, A[i] + K) - Min(min + K, A[i+1] - K))
    }
    return minDiff
}
​
func Min(x, y int) int {
 if x < y {
   return x
 }
 return y
}
​
func Max(x, y int) int {
 if x > y {
   return x
 }
 return y
}
​
​
