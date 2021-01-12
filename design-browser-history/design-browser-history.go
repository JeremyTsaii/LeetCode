type BrowserHistory struct {
    arr []string
    idx int
}
​
​
func Constructor(homepage string) BrowserHistory {
    return BrowserHistory{[]string{homepage}, 0}
}
​
​
func (this *BrowserHistory) Visit(url string)  {
    // Remove forward history
    this.idx += 1
    this.arr = this.arr[:this.idx]
    this.arr = append(this.arr, url)
}
​
​
func (this *BrowserHistory) Back(steps int) string {
    this.idx = Max(this.idx - steps, 0)
    return this.arr[this.idx]
}
​
​
func (this *BrowserHistory) Forward(steps int) string {
    this.idx = Min(len(this.arr) - 1, this.idx + steps)
    return this.arr[this.idx]
}
​
func Max (x int, y int) int {
    if x > y {
        return x
    }
    return y
}
​
func Min (x int, y int) int {
    if x < y {
        return x
    }
    return y
}
​
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * obj := Constructor(homepage);
 * obj.Visit(url);
 * param_2 := obj.Back(steps);
 * param_3 := obj.Forward(steps);
 */
