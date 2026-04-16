import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: value -> indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: process queries
        for (int idx : queries) {
            int val = nums[idx];
            List<Integer> list = map.get(val);

            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list, idx);
            int size = list.size();

            int left = list.get((pos - 1 + size) % size);
            int right = list.get((pos + 1) % size);

            int distLeft = Math.min(Math.abs(idx - left), n - Math.abs(idx - left));
            int distRight = Math.min(Math.abs(idx - right), n - Math.abs(idx - right));

            result.add(Math.min(distLeft, distRight));
        }

        return result;
    }
}