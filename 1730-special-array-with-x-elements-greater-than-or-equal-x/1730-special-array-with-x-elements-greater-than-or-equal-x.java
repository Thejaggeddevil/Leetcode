class Solution {
   public int specialArray(int[] nums) {
    Arrays.sort(nums); // Required for binary search logic
    int n = nums.length;
    
    for (int x = 0; x <= n; x++) {
        int idx = firstGreaterOrEqual(nums, x);
        int count = n - idx;
        if (count == x) return x;
    }
    
    return -1;
}

// Binary search to find first index where nums[i] >= x
private int firstGreaterOrEqual(int[] nums, int x) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] >= x) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return low;
}
}