import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        // X(바다)랑 1~9까지의 자연수(무인도)만 
        // 상하좌우로만 움직일 수 있음
        // 합 = 최대 머물 수 있는 일수
        // 합을 오름차순으로 담아 return
        // 자연수가 존재하지 않으면 -1 담기
        
        int n = maps[0].length(); 
        int m = maps.length; 
        
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        char[][] mapArr = new char[m][n];
        
        for(int i=0; i<m; i++){
            mapArr[i] = maps[i].toCharArray();
        }
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && mapArr[i][j] != 'X'){
                    int sum =0;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    
                    while(!q.isEmpty()){
                        int[] curl = q.poll();
                        int y = curl[0];
                        int x = curl[1];
                        
                        sum += Character.getNumericValue(mapArr[y][x]);
                        
                        for(int k=0; k<4; k++){
                            int ty =  y + dy[k];
                            int tx =  x + dx[k];
                            
                            if(ty >=0 && ty <m && tx >=0 && tx <n && 
                               !visited[ty][tx] && mapArr[ty][tx] != 'X'){
                                visited[ty][tx] = true;
                                q.offer(new int[]{ty,tx});
                                
                            }
                        }
                        
                    }
                    list.add(sum);
                }
            }
        }
        
        
        
        if(list.isEmpty()){
            list.add(-1);
        }
        
        Collections.sort(list);
        return list.stream().mapToInt(i->i).toArray();
    }
}