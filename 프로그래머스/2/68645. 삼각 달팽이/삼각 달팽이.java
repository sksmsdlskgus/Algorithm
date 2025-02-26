import java.util.*;
class Solution {
    public int[] solution(int n) {
        // 높이가 n
        // 아래y++ -> 오른쪽x++-> 왼쪽위x--,y--
        int[] result = new int [n*(n+1)/2];
        int[][] triangle  = new int[n][n];
        
        // 방향: ↓ → ↖
        int[] dx = {0, 1, -1}; 
        int[] dy = {1, 0, -1};
        
        int x = 0, y = 0, dir = 0;
        for(int i=1; i<=result.length; i++){
            triangle[y][x]=i;
            
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            
            if(ny>=n || nx >= n || ny <0 || nx <0 || triangle[ny][nx]!=0){
                dir = (dir +1)%3;
                nx = x+dx[dir];
                ny = y+dy[dir];
            }
            x = nx;
            y = ny;
        }
        int index = 0;
        for (int i = 0; i < n; i++) { // 삼각형값 순서대로 배열에 담기
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }
}