class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // for(int i =0 ;i<nums.length;i++){
        //     if(map.containsKey(nums[i])){
        //         int prev = map.get(nums[i]);
        //         if((i-prev)<=k)return true;
        //     }
        //     map.put(nums[i],i);
        // }
        //Sliding window
        HashSet<Integer> set = new HashSet<>();
        for(int i =0 ; i<nums.length;i++){
            if(set.contains(nums[i]))return true;
            set.add(nums[i]);
            if(i>=k){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}