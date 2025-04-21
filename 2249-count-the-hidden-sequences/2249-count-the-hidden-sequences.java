class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
         long prefixSum = 0;
        long minVal = 0;
        long maxVal = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minVal = Math.min(minVal, prefixSum);
            maxVal = Math.max(maxVal, prefixSum);
        }

        long minX = (long) lower - minVal;
        long maxX = (long) upper - maxVal;

        return (int) Math.max(0, maxX - minX + 1);
    }
}
    