class Solution:
    def maximumSwap(self, num: int) -> int:
        arr = []
        
        while num:
            arr.append(str(num % 10))
            num //= 10
        
        if not arr:
            arr.append("0")
        
        arr = arr[::-1]
        
        # First drop
        last = 0
        for i in range(len(arr) - 1):
            if ord(arr[i]) >= ord(arr[i+1]):
                last = i + 1
            else:
                break
        
        if last < len(arr):
            maxIdx = last
            maxNum = ord(arr[last])
            
            for i in range(last + 1, len(arr)):
                if ord(arr[i]) >= ord(arr[maxIdx]):
                    maxIdx = i
                    maxNum = ord(arr[i])

            for i in range(len(arr)):
                if ord(arr[maxIdx]) > ord(arr[i]):
                    arr[maxIdx], arr[i] = arr[i], arr[maxIdx]
                    break
            
        return int("".join(arr))
                