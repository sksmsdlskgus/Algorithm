import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            int current = arr[i];
            
            for(int n=1; n<=current; n++){
                list.add(current);
            }
            
        }
        
        
        return list.stream().mapToInt(i->i).toArray();
    }
}