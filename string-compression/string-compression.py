class Solution:
    def compress(self, chars: List[str]) -> int:
        start, left, right = 0, 0, 1
        while right < len(chars):
            while right < len(chars) and chars[left] == chars[right]:
                right += 1
            
            if right >= len(chars): # Reach end of string
                chars[start] = chars[left]
                num = str(right - left)
                for i in range(len(num))[::-1]:
                    chars[start+1+i] = num[i]
                return start + len(num) + 1
            elif left + 1 == right: # Letter only appeared once
                chars[start] = chars[left]
                start += 1
                left, right = left + 1, right + 1
            else: # Letter appeared more than once
                chars[start] = chars[left]
                num = str(right - left)
                for i in range(len(num))[::-1]:
                    chars[start+1+i] = num[i]
                start += len(num) + 1
                left = right
                right += 1
​
        chars[start] = chars[left]
        return start + 1
