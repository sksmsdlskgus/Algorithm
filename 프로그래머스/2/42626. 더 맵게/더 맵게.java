import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // k 가 될때 까지 = 안매운 스코빌 + (두번째로 안매운 스코빌*2)
        // 최소 횟수 return 
        // K이상으로 만들 수 없는 경우 -1
        int count = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i: scoville){
            pq.offer(i);
        }
        
        while (pq.size() > 1 && pq.peek() < K){
            int one = pq.poll();
            int two = pq.poll();             
            int mixed = one + (two * 2);
            pq.offer(mixed);
            
            count++;
        }

        return pq.peek() >= K ? count : -1;
    }
}