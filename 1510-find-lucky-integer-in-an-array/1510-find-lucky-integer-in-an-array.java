class Solution {
     public int findLucky(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequency of each number
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int lucky = -1;

        // Check for lucky numbers
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            if (num == freq) {
                lucky = Math.max(lucky, num); // Find max lucky number
            }
        }

        return lucky;
    }
}