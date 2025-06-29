
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);  // Step 1: sort for two-pointer logic
        int mod = 1_000_000_007;
        int n = nums.length;

        // Precompute powers of 2 up to n
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences between left and right are valid
                result = (result + power[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
