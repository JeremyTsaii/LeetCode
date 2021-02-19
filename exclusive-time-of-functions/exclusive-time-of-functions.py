class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        
        exclusive = [0] * n
        
        for log in logs:
            envid, status, time = log.split(":")
            envid = int(envid)
            time = int(time)
            
            if status == "start":
                if stack:
                    exclusive[stack[-1][0]] += time - stack[-1][1]
                stack.append([envid, time])
            else:
                _, time1 = stack.pop()
                exclusive[envid] += time - time1 + 1
                if stack:
                    stack[-1][1] = time + 1
        
        return exclusive