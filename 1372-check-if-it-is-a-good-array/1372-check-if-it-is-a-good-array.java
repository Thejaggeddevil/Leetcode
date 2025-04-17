class Solution {
    public boolean isGoodArray(int[] nums) {
        int n = nums.length;
        int gcd = nums[0];
        for(int i =1; i < n ; i++){
            gcd = findGCD(gcd, nums[i]);

        }
         return gcd == 1; 
        

    }
    private int findGCD(int a , int b ){
        if(b ==0)return a; 
        return findGCD(b , a%b);
    }
}