"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        dic = {None: None}
        
        cur = head
        while cur:
            if cur not in dic:
                dic[cur] = Node(cur.val)
            
            if cur.random in dic:
                dic[cur].random = dic[cur.random]
            else:
                newNode = Node(cur.random.val)
                dic[cur].random = newNode
                dic[cur.random] = newNode
            
            if cur.next in dic:
                dic[cur].next = dic[cur.next]
            else:
                newNode = Node(cur.next.val)
                dic[cur].next = newNode
                dic[cur.next] = newNode
                
            cur = cur.next
        return dic[head]