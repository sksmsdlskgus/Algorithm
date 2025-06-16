import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n,1,2,3);
        return list.toArray(new int[0][]);
    }
    
    private void hanoi(int n, int from, int temp, int to){
        
        if(n == 1){
            list.add(new int[]{from,to});
            return;
        }
        
        hanoi(n-1, from,to,temp); // 1->2
        list.add(new int[]{from,to});
        hanoi(n-1, temp,from,to); // 2->3
        
    }
}