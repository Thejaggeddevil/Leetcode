class Solution {
    public int[] runningSum(int[] nums) {
        int value = 0;
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            value += nums[i];
            sum[i] = value; 
        }
        return sum;
    }
}
