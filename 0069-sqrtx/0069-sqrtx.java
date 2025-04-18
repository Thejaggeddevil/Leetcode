class Solution {
    public int mySqrt(int x) { 
        int start = 1 ;
         int end =  x/2;
        int mid = 0;
        int ans = 0;

        if(x==0||x==1){
            return x;
        }        
        while(start<=end){
            mid =  start +(end-start)/2;
            if((long)mid*mid==x){
                return mid;

            }
            if((long)mid*mid < x){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return ans;
    }

}