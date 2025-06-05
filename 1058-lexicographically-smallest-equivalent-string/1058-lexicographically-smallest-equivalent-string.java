class Solution {
    int[] parent = new int[26]; // Union-Find for 26 lowercase letters

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each char as its own parent
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union all equivalent characters
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build final answer by converting each character in baseStr to its group leader
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            result.append((char) (find(c - 'a') + 'a'));
        }
        return result.toString();
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by choosing lexicographically smaller parent
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}
