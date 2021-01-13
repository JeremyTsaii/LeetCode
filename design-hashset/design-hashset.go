import "fmt"
​
type MyHashSet struct {
    arr [][]int
}
​
​
/** Initialize your data structure here. */
func Constructor() MyHashSet {
    arr := make([][]int, 5000)
    for i := range arr {
        arr[i] = make([]int, 0)
    }
    return MyHashSet{arr}
}
​
​
func (this *MyHashSet) Add(key int)  {
    hash := key % 5000
    arr := this.arr[hash]
    if !arrContainsNum(arr, key) {
        this.arr[hash] = append(arr, key)
    }
}
​
​
func (this *MyHashSet) Remove(key int)  {
    hash := key % 5000
    arr := this.arr[hash]
    this.arr[hash] = arrRemoveNum(arr, key)
}
​
​
/** Returns true if this set contains the specified element */
func (this *MyHashSet) Contains(key int) bool {
    hash := key % 5000
    arr := this.arr[hash]
    return arrContainsNum(arr, key)
}
​
func arrRemoveNum(arr []int, num int) []int {
    for i := range arr {
        if arr[i] == num {
            arr[i] = arr[len(arr) - 1]
            return arr[:len(arr)-1]
        }
    }
    return arr
}
​
func arrContainsNum (arr []int, num int) bool {
