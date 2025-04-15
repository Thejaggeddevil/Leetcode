class Solution {
    public int[][] generateMatrix(int n) {
        int [][] arr = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int val = 1;

        while (top <= bottom && left <= right) {
            // Left to Right
            for (int i = left; i <= right; i++) arr[top][i] = val++;
            top++;

            // Top to Bottom
            for (int i = top; i <= bottom; i++) arr[i][right] = val++;
            right--;

            // Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) arr[bottom][i] = val++;
                bottom--;
            }

            // Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) arr[i][left] = val++;
                left++;
            }
        }

        return arr;
    }
}
