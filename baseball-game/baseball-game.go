import ("strconv")
​
func calPoints(ops []string) int {
    total := 0
    stack := make([]int, 0)
    
    for _, op := range ops {
        if op == "C" {
            total -= stack[len(stack)-1]
            stack = stack[:len(stack)-1]
        } else if op == "D" {
            add := 2 * stack[len(stack) - 1]
            total += add
            stack = append(stack, add)
        } else if op == "+" {
            add := stack[len(stack)-2] + stack[len(stack)-1]
            total += add
            stack = append(stack, add)
        } else {
            num, _ := strconv.Atoi(op)
            stack = append(stack, num)
            total += num
        }
    }
    
    return total
}
