class Solution {
    public long countGood(int[] nums, int k) {
  int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        long pairCount = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            int count = freq.getOrDefault(val, 0);
            pairCount += count;
            freq.put(val, count + 1);

            while (pairCount >= k) {
                result += n - right; // Every subarray starting at left and ending at right or after is good
                int leftVal = nums[left];
                pairCount -= freq.get(leftVal) - 1;
                freq.put(leftVal, freq.get(leftVal) - 1);
                left++;
            }
        }

        return result;
    }
}