class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def backtrack(path):
            if len(path) == len(nums):
                output.append(path)
            for i in range(len(nums)):
                if nums[i] not in path:
                    backtrack(path + [nums[i]])
        
        output = []
        backtrack([])
        return output
