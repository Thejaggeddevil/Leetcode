class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0 ; 
        int  minp = prices[0];
        int n = prices.length;
        for (int i =  0;i<n;i++){
           int  cost = prices[i]-minp;
            maxp = Math.max(maxp, cost);
            minp = Math.min(minp,prices[i]);
            
        }
        return maxp;
        
    }
}