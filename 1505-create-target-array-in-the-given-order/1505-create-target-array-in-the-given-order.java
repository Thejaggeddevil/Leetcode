class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int n  = nums.length; 
        List <Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            arr.add(index[i], nums[i]);

        }
         int [] target = new int [arr.size()];
         for(int i = 0  ; i < n ; i ++){
            target[i] = arr.get(i);
         }

         return target; 
         
        
    }
}