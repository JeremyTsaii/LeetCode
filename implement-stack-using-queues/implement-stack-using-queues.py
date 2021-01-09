from collections import deque
class MyStack:
​
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.q = deque([])
​
    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        size = len(self.q)
        self.q.append(x)
        while size:
            self.q.append(self.q.popleft())
            size -= 1
            
​
    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        return self.q.popleft()
​
    def top(self) -> int:
        """
        Get the top element.
        """
        return self.q[0]
​
    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return not self.q
​
​
# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
