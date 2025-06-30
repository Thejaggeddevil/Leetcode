

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxLen = 0;

        // Step 1: Count frequency of each number
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: For each num, check if num + 1 exists
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                int len = freqMap.get(key) + freqMap.get(key + 1);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}
