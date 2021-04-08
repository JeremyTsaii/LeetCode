class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dic = {
            '2' : ['a','b','c'],
            '3' : ['d','e','f'],
            '4' : ['g','h','i'],
            '5' : ['j','k','l'],
            '6' : ['m','n','o'],
            '7' : ['p','q','r','s'],
            '8' : ['t','u','v'],
            '9' : ['w','x','y','z']
        }
        

        def recurse(digits):
            if not digits:
                return [""]
            output = []

            for d in dic[digits[0]]:
                for pos in recurse(digits[1:]):
                    output.append(d + pos)

            return output
        
        if not digits:
            return []
    
        return recurse(digits)
        
    

            