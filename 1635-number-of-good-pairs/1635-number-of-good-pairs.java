class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int [] temp = new int [101];
        int result = 0;
        for(int i = 0 ; i < n ; i++){
            result = result + temp[nums[i]];
            temp[nums[i]]++ ;

        }
        return result;
        
    }
}