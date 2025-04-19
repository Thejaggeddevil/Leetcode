class Solution {
    public boolean isPerfectSquare(int num) {
         
long start = 1 ;
long end = num; 
long mid = 0 ;
while(start <= end ){
    mid  = start+(end - start)/2;
    long square = mid*mid;

    if(square == num){
        return true;
    }
    else if(square > num){
        end = mid -1 ; 

    }
    else {
        start = mid+1; 
    }
}
return false; 
    }
}

// for(int i = 1 ; i*i<=num; i++){
//              if(i*i ==num){
//             return true; 
//          }

            
//          }
//          return false; 
        
