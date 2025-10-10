import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int frist = commands[i][0];
            int second = commands[i][1];
            int k = commands[i][2];
            
            int[] slice = Arrays.copyOfRange(array,frist-1,second);
            Arrays.sort(slice);
            answer[i] = slice[k-1];

        }
        
        return answer;
    }
}