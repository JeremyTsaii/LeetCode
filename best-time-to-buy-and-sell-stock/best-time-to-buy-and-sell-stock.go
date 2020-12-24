import (
    "fmt"
)
func maxProfit(prices []int) int {
    min := math.MaxInt32
    maxDiff := 0
    
    for _, num := range prices {
        min = Min(min, num)
        maxDiff = Max(maxDiff, num - min)
    }
    
    return maxDiff
}
​
func Min(x int, y int) int {
    if x < y {
        return x
    }
    return y
}
​
func Max (x int, y int) int {
    if x > y {
        return x 
    }
    return y
}
