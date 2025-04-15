class Solution {
    public int majorityElement(int[] arr) {
        int n = arr.length; 
        int count = 0 ; 
        int cand = -1; 
        for(int i  = 0 ; i < n ; i++){
            if(count ==0){
                cand = arr[i];
count = 1;
            }
            else if(arr[i]==cand){
                count++;
            }
            else {
                count--;

            }
            }
            count = 0; 
            for(int i = 0 ; i < n ; i++){
                if(arr[i]==cand){
                    count++;
                }


            }

            if(count>n/2){
                return cand;
            }
        return cand;
    }
}