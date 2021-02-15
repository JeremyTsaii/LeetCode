class Solution:
    def killProcess(self, pid: List[int], ppid: List[int], kill: int) -> List[int]:
        arr = []
        
        graph = {}
        
        for i in range(len(pid)):
            graph[ppid[i]] = graph.get(ppid[i], []) + [pid[i]]
        
        stack = [kill]
        
        while stack:
            node = stack.pop()
            
            arr.append(node)
            
            for child in graph.get(node, []):
                stack.append(child)
        
        return arr