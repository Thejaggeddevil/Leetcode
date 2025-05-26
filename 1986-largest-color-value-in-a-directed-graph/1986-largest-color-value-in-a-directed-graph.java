import java.util.*;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Build graph and indegree
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        int[][] dp = new int[n][26]; // dp[i][c] = max color c ending at i
        Queue<Integer> queue = new LinkedList<>();
        
        // Start with nodes having indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
            dp[i][colors.charAt(i) - 'a'] = 1; // Base case
        }

        int visited = 0, result = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;
            for (int nei : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    // Max of what neighbor already had vs this path
                    dp[nei][c] = Math.max(dp[nei][c], dp[node][c] + (colors.charAt(nei) - 'a' == c ? 1 : 0));
                }
                indegree[nei]--;
                if (indegree[nei] == 0) queue.offer(nei);
            }
            result = Math.max(result, Arrays.stream(dp[node]).max().getAsInt());
        }

        return visited == n ? result : -1; // If not all nodes visited => cycle
    }
}
