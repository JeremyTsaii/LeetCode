class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> arr1 = new ArrayList<>();
        while(n != 0) {
            arr1.add(n % 10);
            n /= 10;
        }
        
        int[] arr = new int[arr1.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr1.get(arr1.size() - 1 - i);
        }
        
        int val = nextPermutation(arr);
        
        if (val == -1) {
            return -1;
        }
        
        long num = 0;
        for (int i : arr) {
            num *= 10;
            num += i;
        }
        
        return num > Integer.MAX_VALUE ? -1 : (int) num;
    }
    
    public int nextPermutation(int[] nums) {
        int idx = -1;
        
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                idx = i-1;
                break;
            }
        }
        
        
        if (idx >= 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[idx]) {
                    replace(nums, i, idx);
                    break;
                }
            }
        } else {
            return -1;
        }

        
        reverse(nums, idx+1, nums.length - 1);
        return 0;
    }
    
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            replace(nums, left, right);
            left++;
            right--;
        }
    }
    
    public void replace(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}