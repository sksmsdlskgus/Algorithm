import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList<>();
        long xLong = (long)x;
        long sum = 0;
        
        for(long i=1; i<= n; i++){
            sum = xLong*i;
            list.add(sum);      
            
        }
        
        return list.stream().mapToLong(i->i).toArray();
    }
}