class Solution:

    def __init__(self, nums: List[int]):
        self.dic = {}

        for i in range(len(nums)):
            self.dic[nums[i]] = self.dic.get(nums[i], [])
            self.dic[nums[i]].append(i)
        
    def pick(self, target: int) -> int:
        arr = self.dic[target]
        r = random.randint(0, len(arr) - 1)
        return arr[r]


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)