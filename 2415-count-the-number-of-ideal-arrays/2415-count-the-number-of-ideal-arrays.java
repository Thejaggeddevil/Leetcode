class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX_N = 10001;
    static final int MAX_EXP = 15;

    long[] fact = new long[MAX_N + MAX_EXP];
    long[] invFact = new long[MAX_N + MAX_EXP];

    public int idealArrays(int n, int maxValue) {
        precomputeFactorials();

        int res = 0;
        for (int i = 1; i <= maxValue; i++) {
            Map<Integer, Integer> primeFactors = getPrimeFactors(i);
            long ways = 1;
            for (int exp : primeFactors.values()) {
                ways = ways * comb(n - 1 + exp, exp) % MOD;
            }
            res = (int)((res + ways) % MOD);
        }
        return res;
    }

    // Step 1: Precompute factorials and inverse factorials
    void precomputeFactorials() {
        int size = fact.length;
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < size; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[size - 1] = modInverse(fact[size - 1]);
        for (int i = size - 2; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    // Step 2: nCk % MOD
    long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    // Step 3: Get prime factorization of number
    Map<Integer, Integer> getPrimeFactors(int x) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= x; i++) {
            while (x % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                x /= i;
            }
        }
        if (x > 1) map.put(x, 1);
        return map;
    }

    // Step 4: Fast modular inverse using Fermat’s little theorem
    long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
