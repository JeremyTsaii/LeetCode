class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        
        p1 = 0
        p2 = 0
        output = []
        
        while p1 < len(firstList) and p2 < len(secondList):
            if firstList[p1][1] >= secondList[p2][0] and firstList[p1][0] <= secondList[p2][1]:
                output.append([max(firstList[p1][0], secondList[p2][0]), min(firstList[p1][1], secondList[p2][1])])
            
            if firstList[p1][1] < secondList[p2][1]:
                p1 += 1
            else:
                p2 += 1
                
        return output