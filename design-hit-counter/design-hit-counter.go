import "fmt"
type HitCounter struct {
    arr []int
}
​
​
/** Initialize your data structure here. */
func Constructor() HitCounter {
    return HitCounter{[]int{}}
}
​
​
/** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
func (this *HitCounter) Hit(timestamp int)  {
    this.arr = append(this.arr, timestamp)
}
​
​
/** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
func (this *HitCounter) GetHits(timestamp int) int {
    for len(this.arr) > 0 && this.arr[0] <= timestamp - 300 {
        this.arr = this.arr[1:]
    }
    return len(this.arr)
}
​
​
/**
 * Your HitCounter object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Hit(timestamp);
 * param_2 := obj.GetHits(timestamp);
 */
