class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] arr = new int [2*n];
        int k = 0;
        for ( int i =  0 ; i < n ; i ++){
            arr[2*i] = nums[i];
            arr[k+1] =  nums[i+n];
            k +=2;
        }
        return arr;


        
    }
}