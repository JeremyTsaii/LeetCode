class Solution:
    def modifyString(self, s: str) -> str:
        output = list(s)
        
        for i in range(len(output)):
            if output[i] == "?":
                left = output[i-1] if i > 0 else 'a'
                right = output[i+1] if i < len(s)-1 and output[i+1] != '?' else 'a'
                if left != 'a' and right != 'a':
                    output[i] = 'a'
                if left != 'b' and right != 'b':
                    output[i] = 'b'
                if left != 'c' and right != 'c':
                    output[i] = 'c'
                    
        return "".join(output)
                
