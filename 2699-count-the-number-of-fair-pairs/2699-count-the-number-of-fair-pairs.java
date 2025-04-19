class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = lowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = upperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            count += (right - left + 1);
        }

        return count;
    }

    // First index where nums[idx] >= target
    private int lowerBound(int[] nums, int start, int end, int target) {
        int res = end + 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    // Last index where nums[idx] <= target
    private int upperBound(int[] nums, int start, int end, int target) {
        int res = start - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
    