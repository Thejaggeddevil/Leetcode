class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k% n;
        rotateno(nums, 0 , n -1);
        rotateno(nums,0,k-1);
        rotateno(nums,k, n-1);
        
    }
    public void rotateno(int [] nums , int start, int end){
        while(start < end ){
            int temp = nums[start];
            nums[start]= nums[end];
            nums[end]= temp;
            start ++;
            end--;
        }
    }

}