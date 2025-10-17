import java.util.*;
// 연속으로 나온건 하나만 -> 중복 제외, 순서 유지하면서 배열로 반환

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        int last = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != last){
                list.add(arr[i]);
                last = arr[i];
            }else continue;
        }
                
        return list.stream().mapToInt(i->i).toArray();
    }
}