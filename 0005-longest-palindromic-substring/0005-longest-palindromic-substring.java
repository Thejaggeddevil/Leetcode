class Solution {
    public String longestPalindrome(String s) {
        
    int n = s.length();
    if(s == null || n <1)return " ";
    int start = 0 ;
    int end = 0 ;
    for(int i = 0 ; i < n  ; i++){
    int length1= expandmore(s, i , i );
    int length2= expandmore(s, i  , i+1);
    int len = Math.max(length1, length2);
    
    if(len>end - start){
        start = i-(len -1)/2;
        end = i+len/2;
    }
    }
    return s.substring(start, end+1);

        
    }
    public int expandmore(String s, int l , int r){
        while(l >= 0 && r < s.length()  && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r -l -1;
                
    }
}