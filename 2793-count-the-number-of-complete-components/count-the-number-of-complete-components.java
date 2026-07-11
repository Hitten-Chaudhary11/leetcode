class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        for (int[] e : edges) union(p, e[0], e[1]);

        int[] nodes = new int[n], edgeCnt = new int[n];
        for (int i = 0; i < n; i++) nodes[find(p, i)]++;
        for (int[] e : edges) edgeCnt[find(p, e[0])]++;

        int ans = 0;
        for (int i = 0; i < n; i++)
            if (find(p, i) == i && edgeCnt[i] == nodes[i] * (nodes[i] - 1) / 2)
                ans++;
        return ans;
    }

    int find(int[] p, int x) { return p[x] == x ? x : (p[x] = find(p, p[x])); }
    void union(int[] p, int a, int b) { p[find(p, a)] = find(p, b); }
}