class Solution {
    public int countCompleteSubarrays(int[] nums) {
     int n = nums.length;

        // Step 1: Count total number of distinct elements
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int totalDistinct = uniqueElements.size();

        // Step 2: Sliding window to count complete subarrays
        int left = 0;
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() == totalDistinct) {
                count += n - right; // All subarrays from current right to end are complete
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                if (freqMap.get(nums[left]) == 0) {
                    freqMap.remove(nums[left]);
                }
                left++;
            }
        }

        return count;
    }

}