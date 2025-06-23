import java.util.*;

class Solution {
    public int[] solution(String[] strlist) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<strlist.length; i++){
            String str = strlist[i];
            list.add(str.length());
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}