import ("fmt")
​
func isBipartite(graph [][]int) bool {
    color := make(map[int]int)
    
    for i := range graph {
        if _, found := color[i]; !found {
            stack := []int{i}
            color[i] = 0
            for len(stack) > 0 {
                node := stack[len(stack)-1]
                stack = stack[:len(stack)-1]
                for _, neighbor := range graph[node] {
                    if _, found := color[neighbor]; !found {
                        stack = append(stack, neighbor)
                        color[neighbor] = color[node] ^ 1
                    } else if color[neighbor] == color[node] {
                        return false
                    }
                }
            }
        }
    }
    return true
}
