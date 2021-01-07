func validPalindrome(s string) bool {
    return helper(s, false)
}
​
func helper(s string, skipped bool) bool {
    left, right := 0, len(s) - 1
    
    for left < right {
        if s[left] == s[right] {
            left += 1
            right -= 1
        } else {
            if skipped {
                return false
            }
            return helper(s[left:right],true) || helper(s[left+1:right+1],true)
        }
    }
    return true
}
