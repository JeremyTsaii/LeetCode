        cur = self.node
        for p in paths:
            if p not in cur.dir:
                cur.dir[p] = Node(name=p)
            cur = cur.dir[p]
                
    def addContentToFile(self, filePath: str, content: str) -> None:
        paths = filePath.split('/')[1:]
        cur = self.node
        for p in paths:
            if p in cur.dir:
                cur = cur.dir[p]
            else:
                cur.dir[p] = Node(False, p, content)
                return
        
        cur.content += content
        
​
    def readContentFromFile(self, filePath: str) -> str:
        paths = filePath.split('/')[1:]
        cur = self.node
        for p in paths:
            cur = cur.dir[p]
        return cur.content
​
​
# Your FileSystem object will be instantiated and called as such:
# obj = FileSystem()
# param_1 = obj.ls(path)
# obj.mkdir(path)
# obj.addContentToFile(filePath,content)
# param_4 = obj.readContentFromFile(filePath)
