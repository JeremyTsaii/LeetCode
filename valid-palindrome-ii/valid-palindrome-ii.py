class Solution:
    def validPalindrome(self, s: str) -> bool:
        def valid(s, num):
            left, right = 0, len(s) - 1
        
            while left < right:
                if s[left] == s[right]:
                    left += 1
                    right -= 1
                else:
                    if num:
                        return valid(s[left:right], 0) or valid(s[left+1:right+1], 0)
                    else:
                        return False

            return True
        
        return valid(s, 1)
    