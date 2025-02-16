import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        // 컴퓨터 개수 = n
        // 연결 정보 배열 = computers
        // computers[i][j] 연결되면 == 1
        // return 네트워크 개수  
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){ // 방문하지 않았던 노드라면?
                bfs(i, computers, visited);
                count++; // 새로운 네트워크
            }
        }
        
        
        return count;
    }
    
    public void bfs (int start, int[][] computers, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        visited[start] = true; // 방문 처리
        
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if(computers[currentNode][i] == 1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        
        
    }
}