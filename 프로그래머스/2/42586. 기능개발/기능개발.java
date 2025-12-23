import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new LinkedList<>();
        
        int length = speeds.length;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<length; i++){
            int x = (100 - progresses[i])/speeds[i]; // 일수
            
            if((100 - progresses[i])%speeds[i] != 0){
                x++;
            }
            
            q.offer(x);
        }
        
        
        while (!q.isEmpty()) {
            int day = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= day) {
                q.poll();
                count++;
            }

            list.add(count);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}