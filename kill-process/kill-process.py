class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        
        graph = {}
        
        for i in range(len(pid)):
            graph[ppid[i]] = graph.get(ppid[i], [])
            graph[ppid[i]].append(pid[i])
    
        arr = []
        stack = [kill]
        
        while stack:
            node = stack.pop()
            
            arr.append(node)
            
            for child in graph.get(node, []):
                stack.append(child)
        
        return arr