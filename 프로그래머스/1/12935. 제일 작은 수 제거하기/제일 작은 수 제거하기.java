import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int minNum = arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] < minNum){
                minNum = arr[i];
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != minNum){
                list.add(arr[i]);
            }
        }
        
        if(list.isEmpty()){
            list.add(-1);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}