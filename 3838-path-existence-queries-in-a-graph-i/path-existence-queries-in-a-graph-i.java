class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        int[] group = new int[n];
        int count = 0;

        // Create connected components
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                count++;
            }
            group[i] = count;
        }

        boolean[] ans = new boolean[queries.length];

        // Answer queries
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            ans[i] = (group[u] == group[v]);
        }

        return ans;
    }
}