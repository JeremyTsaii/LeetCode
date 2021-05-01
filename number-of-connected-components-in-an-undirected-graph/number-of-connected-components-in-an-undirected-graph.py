class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        
        adj = [[] for _ in range(n)]
        
        for a, b in edges:
            adj[a].append(b)
            adj[b].append(a)
        
        visited = [False for _ in range(n)]
        
        count = 0
        
        for i in range(n):
            if not visited[i]:
                count += 1
                stack = [i]
                visited[i] = True
                
                while stack:
                    node = stack.pop()
                    for neighbor in adj[node]:
                        if not visited[neighbor]:
                            stack.append(neighbor)
                            visited[neighbor] = True
                
        
        return count
        