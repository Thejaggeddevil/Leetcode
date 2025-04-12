class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n  = nums.length;
        int [] res  = new int [n];
        int [] temp = new int [101];
        for(int i = 0; i< n ; i++){
            temp[nums[i]]++;

        }
        for(int i  = 1 ; i < 101; i++){
            temp [i] += temp [i-1];
        }

        for ( int i = 0 ; i < n ; i ++){
            if(nums[i] == 0 ){
                res[i] = 0 ;
            }
            else{
                res[i] = temp[nums[i] -1];
            }
        }
        return res;
        
    }
}