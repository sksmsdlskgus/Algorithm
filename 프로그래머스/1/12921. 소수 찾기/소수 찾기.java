class Solution {
    public int solution(int n) {
        //에라(모르겠다)토스(사용중)테네스의 체(테니스의 채?)
        
        boolean[] visited = new boolean[n+1];
        int count = 0;
        
        for(int i=2; i<=n; i++){
            if(!visited[i]){
                count ++;
                
                for(int j=i*2; j<=n; j+=i){
                    visited[j] = true;
                }
            }
        }
        
        return count;
    }
}