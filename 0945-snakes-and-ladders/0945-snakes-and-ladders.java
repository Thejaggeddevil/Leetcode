import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flat = new int[n * n];
        boolean leftToRight = true;
        int idx = 0;

        // Flatten the board in boustrophedon order
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flat[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flat[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n];
        queue.offer(0);
        visited[0] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                int curr = queue.poll();

                if (curr == n * n - 1) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next >= n * n) break;

                    int dest = flat[next] == -1 ? next : flat[next] - 1;

                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
