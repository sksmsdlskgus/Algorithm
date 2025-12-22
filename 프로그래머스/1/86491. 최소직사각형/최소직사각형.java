import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 가로,세로 상관없이 
        int max_x = 0;
        int min_y = 0;
        
        for(int i=0; i<sizes.length; i++){
            int x = sizes[i][0]; 
            int y = sizes[i][1];

            int big = Math.max(x,y);
            int small = Math.min(x,y);

            max_x = Math.max(max_x,big);
            min_y = Math.max(min_y,small);
            
        }
        
        
        return max_x * min_y;
    }
}