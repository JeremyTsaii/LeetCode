class SparseVector:
    def __init__(self, nums: List[int]):
        self.dic = {}
        for i in range(len(nums)):
            if nums[i]:
                self.dic[i] = nums[i]

    # Return the dotProduct of two sparse vectors
    def dotProduct(self, vec: 'SparseVector') -> int:
        total = 0
        for i in self.dic:
            if i in vec.dic:
                total += self.dic[i] * vec.dic[i]
        return total

# Your SparseVector object will be instantiated and called as such:
# v1 = SparseVector(nums1)
# v2 = SparseVector(nums2)
# ans = v1.dotProduct(v2)