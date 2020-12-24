import (
    "strconv"
)
func nextGreaterElement(n int) int {
    byteArr := []byte(strconv.Itoa(n))
    if len(byteArr) < 2 {
        return -1
    }
    
    var j int
    for j = len(byteArr) - 2; j >= 0 && byteArr[j] >= byteArr[j+1]; j-- {
    }
    
    if j == -1 {
        return j
    }
    
    var k int
    for k = len(byteArr) - 1; k > j && byteArr[j] >= byteArr[k]; k-- {
    }
    
    byteArr[j], byteArr[k] = byteArr[k], byteArr[j]
    
    for j, k = j+1, len(byteArr)-1; j < k; j, k = j+1, k-1 {
        byteArr[j], byteArr[k] = byteArr[k], byteArr[j]
    }
    
    num, err := strconv.ParseInt(string(byteArr), 10, 32)
    if err != nil {
        return -1
    }
    return int(num)
}
