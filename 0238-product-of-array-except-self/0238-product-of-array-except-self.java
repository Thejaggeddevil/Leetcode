class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] ans = new int [n];
        int mult = 1;
        for(int i = 0 ; i < n ; i++){
            ans[i]=  mult; 
            mult = mult*nums[i];

        }
        mult = 1; 
        for(int i = n -1 ; i >=0 ; i--){
            ans[i] = ans[i]*mult;
            mult =  mult* nums[i];
        }
        return ans;
        
    }
}