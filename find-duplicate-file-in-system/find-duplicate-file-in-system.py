class Solution:
    def findDuplicate(self, paths: List[str]) -> List[List[str]]:
        dic = {}
        output = []
        
        for path in paths:
            stuff = path.split()
            direc = stuff[0]
            for i in range(1, len(stuff)):
                stuff2 = stuff[i].split("(")
                file = direc + "/" + stuff2[0]
                content = stuff2[1][:-1]
                existing = dic.get(content, [])
                existing.append(file)
                dic[content] = existing
        
        for key in dic:
            if len(dic[key]) > 1:
                output.append(dic[key])
        return output
        
        