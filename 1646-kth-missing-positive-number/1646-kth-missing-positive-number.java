class Solution {
    public int findKthPositive(int[] arr, int k) {
        
    int missingCount = 0;
    int current = 1;
    int i = 0;

    while (true) {
        if (i < arr.length && arr[i] == current) {
            i++; // number is in array
        } else {
            missingCount++; // number is missing
            if (missingCount == k) {
                return current;
            }
        }
        current++;
    }
        
    }
}
