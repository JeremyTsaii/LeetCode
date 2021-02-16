from collections import deque
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not n:
            return len(tasks)
        
        freqs = [0] * 26
        
        for task in tasks:
            freqs[ord(task) - ord('A')] += 1
        
        freqs.sort()
        
        maximum = freqs.pop()
        idle = (maximum-1) * n
        
        while freqs and idle > 0:
            idle -= min(freqs.pop(), maximum - 1)
        idle = max(0, idle)
        return idle + len(tasks)