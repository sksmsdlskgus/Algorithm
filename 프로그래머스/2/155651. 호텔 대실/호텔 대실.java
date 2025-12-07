import java.util.*;

class Solution {
    public int solution(String[][] book_time) {

        Arrays.sort(book_time,
            Comparator.comparing((String[] a) -> a[0])
                      .thenComparing(a -> a[1])
        );
        
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String[] time : book_time){
            String start = time[0]; // 입실시간
            String end = time[1]; // 퇴실시간
            
            int startTime = timearraysplit(start);
            int endTime = timearraysplit(end) + 10;
            
            if(!pq.isEmpty() && pq.peek() <= startTime){
                 pq.poll();
            }
            
            pq.offer(endTime);
            
        }
       
        
        return pq.size();
    }
    
    private int timearraysplit(String time){
        
        String[] timeArray = time.split(":");
        int time_hh = Integer.parseInt(timeArray[0]);
        int time_mm = Integer.parseInt(timeArray[1]);
        
        return time_hh * 60 + time_mm;
    }
}