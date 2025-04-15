class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int count = 0;
        
        // Directions: right, down, left, up
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int len = 1; // initial steps in a direction
        int r = rStart, c = cStart;
        int dir = 0; // starting direction is right (east)

        while (count < rows * cols) {
            for (int i = 0; i < 2; i++) { // for each direction twice before increasing step size
                for (int j = 0; j < len; j++) {
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count][0] = r;
                        result[count][1] = c;
                        count++;
                    }
                    r += directions[dir][0];
                    c += directions[dir][1];
                }
                dir = (dir + 1) % 4; // turn to next direction clockwise
            }
            len++; // increase step size after 2 directions
        }

        return result;
    }
}
