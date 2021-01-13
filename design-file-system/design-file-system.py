class FileSystem:
​
    def __init__(self):
        self.dir = {}
​
    def createPath(self, path: str, value: int) -> bool:
        paths = path.split('/')[1:]
        cur = self.dir
​
        for i in range(len(paths) - 1):
            if paths[i] not in cur:
                return False
            cur = cur[paths[i]]
        
        if paths[-1] in cur:
            return False
        
        cur[paths[-1]] = {'/': value}
        return True
        
​
    def get(self, path: str) -> int:
        paths = path.split('/')[1:]
        cur = self.dir
        
        for x in paths:
            if x not in cur:
                return -1
            cur = cur[x]
        
        return cur['/']
​
​
# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.createPath(path,value)
# param_2 = obj.get(path)
