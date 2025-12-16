import java.util.*;

class Solution {
    // 대각선 각 갯수 2n - 1
    int count;
    boolean[] col;    // 열에 퀸 있나
    boolean[] diag1;  // (row + col) 대각선 합 같음
    boolean[] diag2;  // (row - col + n - 1) 대각선 합 같음 (음수 방지 n - 1)
    int N;
    
    
    public int solution(int n) {
        N = n;
        count = 0;
        col = new boolean[n];  
        diag1 = new boolean[2*n-1]; 
        diag2 = new boolean[2*n-1];
        
        dfs(0);
        
        return count;
    }
    
    private void dfs(int row){
        
        if(row == N){
            count++;
            return;
        }
        
        for(int i=0; i<N; i++){
            int d1 = row + i;
            int d2 = row - i + (N-1);
            
            if(col[i] || diag1[d1] || diag2[d2])
                continue;
            
            col[i] = diag1[d1] = diag2[d2] = true;
            
            dfs(row +1);
            
            col[i] = diag1[d1] = diag2[d2] = false;
        }
        
    }
    
    
}