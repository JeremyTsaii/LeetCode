func merge(nums1 []int, m int, nums2 []int, n int)  {
    open := len(nums1) - 1
    p1, p2 := m - 1, n - 1
    
    for open >= 0 {
        if p2 < 0 || (p1 >= 0 && nums1[p1] > nums2[p2]) {
            nums1[open] = nums1[p1]
            p1 -= 1
        } else {
            nums1[open] = nums2[p2]
            p2 -= 1
        }
        open -= 1
    }
}
