class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;

        // int expectedSum = n * (n + 1) / 2;
        // int actualSum = 0;

        // for (int num : nums) {
        //     actualSum += num;
        // }

        // return expectedSum - actualSum;

        int xor = 0 ;
        int n = nums.length;
        for(int i = 0 ; i <=n;i++){
            xor ^=i;
        }
        for(int num:nums){
            xor^=num;
        }
        return xor;
    }
}
