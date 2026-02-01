class Solution {
    public int strStr(String haystack, String needle) {
        // if(needle.length()==0)return 0;
        // int n = needle.length();
        // int m = haystack.length();
        // for(int i =0 ; i <=m-n;i++){
        //     int j = 0 ;
        //     while(j<n&&haystack.charAt(i+j)==needle.charAt(j)){
        //         j++;
        //     }
        //     if(j==n){
        //         return i ;
        //     }
        // }
        // return -1;
//this is the answer two:-
        return haystack.indexOf(needle);
    }
}