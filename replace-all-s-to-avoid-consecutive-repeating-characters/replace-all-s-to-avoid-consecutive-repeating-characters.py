class Solution:
    def modifyString(self, s: str) -> str:
        output = ''
        
        for i in range(len(s)):
            if s[i] == '?':
                left = i - 1
                right = i + 1
​
                if left < 0:
                    val = ord(s[right]) + 1 if right < len(s) else ord('a')
                    if not (ord('a') <= val <= ord('z')):
                        val = ord('a')
                    output += chr(val)
                elif right >= len(s) or s[right] == '?':
                    val = ord(output[left]) + 1
                    if not (ord('a') <= val <= ord('z')):
                        val = ord('a')
                    output += chr(val)
                else:
                    val = (ord(output[left]) + ord(s[right]))//2
                    if val == ord(output[left]) or val == ord(s[right]):
                        val = min(ord(output[left]), ord(s[right])) -1
                        if val < ord('a'):
                            val = ord('z')
                    output += chr(val)
            else:
