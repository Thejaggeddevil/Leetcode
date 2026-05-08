class Solution {

    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int maxVal = 0;
        for (int x : nums) maxVal = Math.max(maxVal, x);

        // Prime sieve
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);

        if (maxVal >= 0) isPrime[0] = false;
        if (maxVal >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxVal; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Map: prime -> all indices whose value divisible by prime
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            int temp = val;

            for (int p = 2; p * p <= temp; p++) {
                if (temp % p == 0) {

                    primeToIndices
                        .computeIfAbsent(p, k -> new ArrayList<>())
                        .add(i);

                    while (temp % p == 0) {
                        temp /= p;
                    }
                }
            }

            if (temp > 1) {
                primeToIndices
                    .computeIfAbsent(temp, k -> new ArrayList<>())
                    .add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        // To avoid processing same prime teleport multiple times
        Set<Integer> usedPrime = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) return steps;

                // Adjacent moves
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // Prime teleport
                int val = nums[i];

                if (isPrime[val] && !usedPrime.contains(val)) {

                    usedPrime.add(val);

                    List<Integer> list = primeToIndices.get(val);

                    if (list != null) {
                        for (int idx : list) {
                            if (!visited[idx]) {
                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}