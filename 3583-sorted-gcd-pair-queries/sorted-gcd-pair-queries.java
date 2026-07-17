class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // divCnt[d] = count of numbers divisible by d
        int[] divCnt = new int[max + 1];
        for (int d = 1; d <= max; d++) {
            for (int multiple = d; multiple <= max; multiple += d) {
                divCnt[d] += freq[multiple];
            }
        }

        // gcdPairs[d] = number of pairs whose gcd is exactly d
        long[] gcdPairs = new long[max + 1];
        for (int d = max; d >= 1; d--) {
            long cnt = divCnt[d];
            gcdPairs[d] = cnt * (cnt - 1) / 2;

            for (int multiple = d * 2; multiple <= max; multiple += d) {
                gcdPairs[d] -= gcdPairs[multiple];
            }
        }

        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdPairs[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1; // 0-indexed query
            int l = 1, r = max;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (prefix[mid] >= target)
                    r = mid;
                else
                    l = mid + 1;
            }
            ans[i] = l;
        }

        return ans;
    }
}