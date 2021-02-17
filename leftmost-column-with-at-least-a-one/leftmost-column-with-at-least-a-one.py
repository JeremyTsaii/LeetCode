# """
# This is BinaryMatrix's API interface.
# You should not implement it, or speculate about its implementation
# """
#class BinaryMatrix(object):
#    def get(self, row: int, col: int) -> int:
#    def dimensions(self) -> list[]:

class Solution:
    def leftMostColumnWithOne(self, binaryMatrix: 'BinaryMatrix') -> int:
        rows, cols = binaryMatrix.dimensions()
        
        row, col = 0, cols - 1
        
        while row < rows:
            while col >= 0 and binaryMatrix.get(row, col):
                col -= 1
            row += 1
        
        return -1 if col == cols - 1 else  col + 1