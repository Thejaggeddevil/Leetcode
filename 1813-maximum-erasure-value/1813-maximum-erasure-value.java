import java.util.HashSet;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        int maxSum = 0, currentSum = 0;
        HashSet<Integer> seen = new HashSet<>();

        while (right < nums.length) {
            // if duplicate, shrink from the left
            while (seen.contains(nums[right])) {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            // add current number
            seen.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);

            right++;
        }

        return maxSum;
    }
}

