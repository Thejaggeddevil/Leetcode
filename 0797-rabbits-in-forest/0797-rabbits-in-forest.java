class Solution {
    public int numRabbits(int[] answers) {
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int ans : answers) {
            countMap.put(ans, countMap.getOrDefault(ans, 0) + 1);
        }
        
        int total = 0;
        for (int x : countMap.keySet()) {
            int groupSize = x + 1;
            int rabbitsCount = countMap.get(x);
            
            // number of groups needed
            int groups = (int) Math.ceil(rabbitsCount * 1.0 / groupSize);
            total += groups * groupSize;
        }
        
        return total;
    }
}

