class Solution {
    public List<Integer> majorityElement(int[] nums) {
         int n = nums.length;
        int count1 = 0 , count2 = 0;
        Integer candidate1 = null , candidate2 = null;
        for(int num : nums){
            if(candidate1 !=null && num == candidate1){
                count1++;
                
            }
            else if(candidate2 != null && num == candidate2){
                count2++;
            }
            else if(count1 == 0){
                candidate1= num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
                
            }
            else{
                count1 --;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num :nums){
            if(num == candidate1)count1 ++;
            else if(num == candidate2)count2 ++;
        }
        // Your code goes here.
        List<Integer> result = new ArrayList<>();
        if(count1>n/3)result.add(candidate1);
        if(count2>n/3) result. add (candidate2);
        Collections.sort(result);
        return result;
    }
}

    