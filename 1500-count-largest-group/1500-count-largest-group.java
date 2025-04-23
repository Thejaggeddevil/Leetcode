class Solution {
    public int countLargestGroup(int n) {
        
        
        HashMap<Integer, Integer> groupCounts = new HashMap<>();
        int maxSize = 0;

        for (int i = 1; i <= n; i++) {
            int digitSum = getDigitSum(i);
            groupCounts.put(digitSum, groupCounts.getOrDefault(digitSum, 0) + 1);
            maxSize = Math.max(maxSize, groupCounts.get(digitSum));
        }

        int count = 0;
        for (int size : groupCounts.values()) {
            if (size == maxSize) {
                count++;
            }
        }

        return count;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    }