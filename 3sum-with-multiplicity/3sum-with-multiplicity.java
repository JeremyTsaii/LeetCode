class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int val = target - arr[i];
            int left = i + 1, right = arr.length - 1;
            while (left < right) {
                if (arr[left] + arr[right] == val) {
                    int totalLeft = 1, totalRight = 1;
                    
                    while (left + totalLeft < right && arr[left] == arr[left + totalLeft]) {
                        totalLeft++;
                    }
                    while (left + totalLeft <= right - totalRight && arr[right] == arr[right - totalRight]) {
                        totalRight++;
                    }
                    
                    count += arr[left] == arr[right] ? (right - left + 1) * (right - left) / 2 : totalLeft * totalRight;
                    left += totalLeft;
                    right -= totalRight;
                } else if (arr[left] + arr[right] < val) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return (int) (count % 1_000_000_007);
    }
}