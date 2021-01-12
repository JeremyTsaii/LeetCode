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
    this.arr = this.arr[:this.idx + 1]
    this.arr = append(this.arr, url)
    this.idx += 1
}
​
​
func (this *BrowserHistory) Back(steps int) string {
    if steps > this.idx {
        this.idx = 0
        return this.arr[0]
    }
    this.idx -= steps
    return this.arr[this.idx]
}
​
​
func (this *BrowserHistory) Forward(steps int) string {
    if steps > len(this.arr) - this.idx - 1 {
        this.idx = len(this.arr) - 1
        return this.arr[this.idx]
    }
    this.idx += steps
    return this.arr[this.idx]
}
​
​
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * obj := Constructor(homepage);
 * obj.Visit(url);
 * param_2 := obj.Back(steps);
 * param_3 := obj.Forward(steps);
 */
