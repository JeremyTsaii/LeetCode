class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        output = []
        
        graph = {}
        
        for account in accounts:
            name = account[0]
            for mail in account[1:]:
                graph[mail] = [name, set()]
        
        for account in accounts:
            for i in range(1, len(account)):
                for j in range(1, len(account)):
                    if i != j:
                        graph[account[i]][1].add(account[j])
                        graph[account[j]][1].add(account[i])
        
        seen = set()
        for mail in graph:
            if mail not in seen:
                stack = [mail]
                seen.add(mail)

                person = []

                while stack:
                    node = stack.pop()
                    person.append(node)

                    for neighbor in graph[node][1]:
                        if neighbor not in seen:
                            seen.add(neighbor)
                            stack.append(neighbor)

                person.sort()
                output.append([graph[mail][0]] + person)
        
        return output