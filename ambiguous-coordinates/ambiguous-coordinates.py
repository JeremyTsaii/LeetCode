class Solution:
    def ambiguousCoordinates(self, s: str) -> List[str]:
        
        output = set()
        
        for i in range(1, len(s) - 2):
            left = s[1:i+1]
            right = s[i+1:-1]
            
            leftPos = self.possibleNums(left)
            rightPos = self.possibleNums(right)     

            for l in leftPos:
                for r in rightPos:
                    output.add("(" + l + ", " + r + ")")     
        
        return list(output)
    
    def possibleNums(self, s):
        output = []
        
        if len(s) == 1:
            output.append(s)
        else:
            if s[0] == "0":
                found = False
                for c in s:
                    if c != "0":
                        found = True
                if found and s[-1] != "0":
                    output.append("0." + s[1:])
            else:
                output.append(s)
                if s[-1] != "0":
                    for i in range(len(s) - 1):
                        output.append(s[:i+1] + "." + s[i+1:])

        return output