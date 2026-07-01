import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];

        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        // Add all thieves
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Multi-source BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = cur[0] + dx[k];
                int y = cur[1] + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }

        // Max Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[2] - a[2]);

        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int x = cur[0];
            int y = cur[1];
            int safe = cur[2];

            if (visited[x][y])
                continue;

            visited[x][y] = true;

            if (x == n - 1 && y == n - 1)
                return safe;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    pq.offer(new int[]{
                            nx,
                            ny,
                            Math.min(safe, dist[nx][ny])
                    });
                }
            }
        }

        return 0;
    }
}