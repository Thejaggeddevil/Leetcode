/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
    int low = 1;
    int high = n;

    while(low<=high){
        int num  =  low + (high - low) / 2; //5
        int res = guess(num); //6

        if(res == 0){
            return num; 

        }
        else if(res <0){
            high = num -1;
        }
        else{
            low = num+1;
        }
    }
    return -1;
    }
}