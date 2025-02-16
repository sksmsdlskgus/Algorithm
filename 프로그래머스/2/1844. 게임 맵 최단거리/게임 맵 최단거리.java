import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        return bfs(maps, n, m);
    }
    
    public int bfs(int[][] maps, int n, int m) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1}; 
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{0, 0});  // 시작 지점 (0,0) 큐에 추가
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                // 상하좌우 이동한 좌표
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵을 벗어나지 않고, 벽이 아닌 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1; // 거리 업데이트
                    queue.offer(new int[]{nx, ny}); // 다음 탐색을 위해 큐에 추가
                }
            }
        }
        
        return maps[n - 1][m - 1] > 1 ? maps[n - 1][m - 1] : -1;
    }
}
