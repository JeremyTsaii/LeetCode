class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        graph = {}
        
        for account in accounts:
            name = account[0]
            emails = account[1:]
            for mail in emails:
                if mail not in graph:
                    graph[mail] = [name, []]
                for mail2 in emails:
                    if mail != mail2:
                        graph[mail][1].append(mail2)
            
        output = []
        seen = set()

        for mail in graph:
            if mail not in seen:
                name, _ = graph[mail]
                stack = [mail]
                seen.add(mail)

                cur = []

                while stack:
                    node = stack.pop()
                    cur.append(node)

                    for neighbor in graph[node][1]:
                        if neighbor not in seen:
                            seen.add(neighbor)
                            stack.append(neighbor)

                cur.sort()
                output.append([name] + cur)
        
        return output