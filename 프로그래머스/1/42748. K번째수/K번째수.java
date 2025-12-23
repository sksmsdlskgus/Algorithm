import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // i,j,k 
        
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            
            int[] slice = Arrays.copyOfRange(array,start-1,end);
            Arrays.sort(slice);
            
            answer[i] = slice[k-1];
        }
        
        
        return answer;
    }
}