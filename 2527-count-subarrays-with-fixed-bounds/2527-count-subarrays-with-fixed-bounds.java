class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        
 
    int n = nums.length;
    int minPos = -1, maxPos = -1, leftBound = -1;
    long count = 0;

    for (int i = 0; i < n; i++) {
        if (nums[i] < minK || nums[i] > maxK) {
            leftBound = i; // invalid window
        }
        if (nums[i] == minK) {
            minPos = i;
        }
        if (nums[i] == maxK) {
            maxPos = i;
        }

        int validStart = Math.min(minPos, maxPos);
        if (validStart > leftBound) {
            count += validStart - leftBound;
        }
    }

    return count;
}
    }