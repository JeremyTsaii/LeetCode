        self.arr[idx].append([key, value])
​
    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        idx = key % 769
        
        for k, v in self.arr[idx]:
            if k == key:
                return v
        
        return -1
​
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        idx = key % 769
        
        for i in range(len(self.arr[idx])):
            k, v = self.arr[idx][i]
            if k == key:
                self.arr[idx][i] = self.arr[idx][len(self.arr[idx]) - 1]
                self.arr[idx] = self.arr[idx][:-1]
                return
​
​
# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
