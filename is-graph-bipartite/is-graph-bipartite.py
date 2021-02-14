class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        
        seen = {}
        stack = []
        for i in range(len(graph)):
            if i not in seen:
                stack.append(i)
                seen[i] = 1
                while stack:
                    node = stack.pop()
                    
                    for neighbor in graph[node]:
                        if neighbor in seen:
                            if not seen[node]^seen[neighbor]:
                                return False
                        else:
                            stack.append(neighbor)
                            seen[neighbor] = not seen[node]
        
        return True