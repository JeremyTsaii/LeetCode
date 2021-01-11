class Node:
    def __init__(self, left, right, val, key):
        self.left = left
        self.right = right
        self.val = val
        self.key = key
    
    def setLeft(self, left) -> None:
        self.left = left
​
    def setRight(self, right) -> None:
        self.right = right
​
class LRUCache:
​
    def __init__(self, capacity: int):
        self.head = None
        self.tail = None
        self.capacity = capacity
        self.dic = {}
        
​
    def get(self, key: int) -> int:
        if key not in self.dic:
            return -1
        node = self.dic[key]
        if node != self.head:
            # Detach neighbors and bring to head
            if node == self.tail:
                self.tail = node.left
            if node.left:
                node.left.setRight(node.right)
            if node.right:
                node.right.setLeft(node.left)
​
            self.head.left = node
            node.right = self.head
            node.left = None
            self.head = node
​
        # print(self.dic)
        # print(self.head.val)
        # print(self.tail.val)
        return node.val
​
    def put(self, key: int, value: int) -> None:
        if self.get(key) != -1:
            self.head.val = value
        else:
            node = Node(None, self.head, value, key)
            self.dic[key] = node
            if self.head:
                self.head.left = node
            self.head = node
            if not self.tail:
                self.tail = self.head
            if len(self.dic) > self.capacity:
                tail = self.tail
                del self.dic[tail.key]
                if tail.left:
                    tail.left.setRight(None)
                    self.tail = tail.left
        # print(self.dic)
        # print(self.head.val)
        # print(self.tail.val)
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
