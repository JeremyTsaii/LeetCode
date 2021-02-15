"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    def insert(self, head: 'Node', insertVal: int) -> 'Node':
        newNode = Node(insertVal)
        if not head:
            newNode.next = newNode
            return newNode
        
        prev = head
        cur = head.next
        seen = set()
        
        while prev != cur and not prev.val <= insertVal <= cur.val:
            if prev.val >= cur.val and (insertVal >= prev.val or insertVal <= cur.val) and cur in seen:
                newNode.next = cur
                prev.next = newNode
                return head
            seen.add(prev)
            prev = cur
            cur = cur.next

        newNode.next = cur
        prev.next = newNode
        
        return head