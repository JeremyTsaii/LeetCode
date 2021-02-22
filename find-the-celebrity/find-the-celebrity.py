# The knows API is already defined for you.
# return a bool, whether a knows b
# def knows(a: int, b: int) -> bool:

class Solution:
    def findCelebrity(self, n: int) -> int:
        for i in range(n):
            found = False
            for j in range(n):
                if i != j:
                    if knows(i, j) or not knows(j, i):
                        found = True
                        break
            if not found:
                return i
        return -1
                
