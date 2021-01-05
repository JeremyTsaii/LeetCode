type SparseVector struct {
    vector []int
}
​
func Constructor(nums []int) SparseVector {
    return SparseVector{nums}
}
​
// Return the dotProduct of two sparse vectors
func (this *SparseVector) dotProduct(vec SparseVector) int {
    sum := 0
    for i := range vec.vector {
        sum += vec.vector[i] * (*this).vector[i]
    }
    return sum
}
​
/**
 * Your SparseVector object will be instantiated and called as such:
 * v1 := Constructor(nums1);
 * v2 := Constructor(nums2);
 * ans := v1.dotProduct(v2);
 */
