import (
    "fmt"
)
func canPermutePalindrome(s string) bool {
    m := make(map[rune]int)
    
    for _, char := range s {
        m[char] += 1
    }
    
    odd := 0
    
    for _, val := range m {
        if val % 2 != 0 {
            odd += 1
        }
    }
    
    if len(s) % 2 == 0 {
        return odd == 0
    }
    return odd == 1 
}
