class Solution:
    def calculate(self, s: str) -> int:
        curNum = 0
        total = 0
        curOp = '+'
        s+='+'
        stack = []
        for c in s:
            if c.isdigit():
                curNum = curNum*10 + int(c)
            elif c == ' ':
                continue
            else:
                if curOp == '+':
                    stack.append(curNum)
                elif curOp == '-':
                    stack.append(-curNum)
                elif curOp == '*':
                    operant = stack.pop()
                    stack.append((operant*curNum))
                elif curOp == '/':
                    operant = stack.pop()
                    stack.append(math.trunc((operant/curNum)))
                curNum = 0
                curOp = c
                
        return sum(stack)