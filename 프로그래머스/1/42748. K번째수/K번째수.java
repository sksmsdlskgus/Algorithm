import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> kList = new ArrayList<>(); // k번째 수 담기
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0]-1; //i
            int end = commands[i][1]; //j
            int k = commands[i][2]; //k
            
            int[] slice = Arrays.copyOfRange(array, start, end);
            Arrays.sort(slice);
            
            for(int j=0; j<slice.length; j++){
                if(j==k-1){
                    kList.add(slice[j]);
                }
            }
            
        }
        
        return kList.stream().mapToInt(i->i).toArray();
    }
}