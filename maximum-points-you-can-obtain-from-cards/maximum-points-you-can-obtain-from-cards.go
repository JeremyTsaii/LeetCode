import "fmt"
func maxScore(cardPoints []int, k int) int {
    n := len(cardPoints) - k
    left, right := 0, n - 1
    total := 0
    cur := 0
    for i, num := range cardPoints {
        total += num
        if i == n-1 {
            cur = total
        }
    }
    
    minimum := cur
    for right < len(cardPoints) - 1 {
        cur = cardPoints[right + 1] - cardPoints[left] + cur
        if cur < minimum {
            minimum = cur
        }
        left += 1
        right += 1
    }
​
    return total - minimum
}
