class Solution {
    private static final int MOD = 1_000_000_007;
    public int countSubsets(int[] arr) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        int[] freq = new int[31];
        for (int num : arr) {
            freq[num]++;
        }
        int[] primeMask = new int[31];
        for (int i = 2; i <= 30; i++) {
            int temp = i;
            int mask = 0;
            boolean isValid = true;
            for (int j = 0; j < primes.length; j++) {
                int count = 0;
                while (temp % primes[j] == 0) {
                    temp /= primes[j];
                    count++;
                }
                if (count > 1) {
                    isValid = false;
                    break;
                }
                if (count == 1) {
                    mask |= (1 << j);
                }
            }
            if (isValid) {
                primeMask[i] = mask;
            } else {
                primeMask[i] = -1;
            }
        }
        long[] dp = new long[1 << 10];
        dp[0] = 1;
        for (int i = 2; i <= 30; i++) {
            if (freq[i] == 0 || primeMask[i] == -1) continue;
            int currentMask = primeMask[i];
            long count = freq[i];
            for (int mask = (1 << 10) - 1; mask >= 0; mask--) {
                if ((mask & currentMask) == 0 && dp[mask] > 0) {
                    dp[mask | currentMask] = (dp[mask | currentMask] + dp[mask] * count) % MOD;
                }
            }
        }
        long totalSubsets = 0;
        for (int mask = 1; mask < (1 << 10); mask++) {
            totalSubsets = (totalSubsets + dp[mask]) % MOD;
        }
        long powerOfTwo = 1;
        for (int i = 0; i < freq[1]; i++) {
            powerOfTwo = (powerOfTwo * 2) % MOD;
        }
        return (int) ((totalSubsets * powerOfTwo) % MOD);
    }
}