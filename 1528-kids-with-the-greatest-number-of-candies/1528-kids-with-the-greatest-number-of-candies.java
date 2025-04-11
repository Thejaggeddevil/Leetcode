class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max =  -1;
        int n = candies.length;
     List <Boolean> ans = new ArrayList<>(n);
     for(int i = 0 ; i < n ; i ++){
        max = Math.max(max, candies[i]);
     }
        for(int i : candies)
        ans.add(i >= max - extraCandies);
     
        return ans;
    }
}