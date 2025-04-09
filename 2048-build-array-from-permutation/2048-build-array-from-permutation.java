class Solution {
    public int[] buildArray(int[] nums) {
            int n = nums.length;
        int k = nums.length + 1;
        for(int i = 0 ; i <n; i ++){
            int a = nums[i];
            int b = nums[nums[i]]%k;
            nums[i]= a + b * k ;
        }
        for(int i = 0  ; i < n ; i++){
            nums [i]= nums[i ]/ k ;
        }

        return nums;
        
    }
}
       