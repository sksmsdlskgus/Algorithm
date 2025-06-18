import java.util.*;

class Solution {
    public long solution(int k, int d) {
        // x축 방향으로 a*k , y축 방향으로 b*k에 점 찍기 
        // 원점과 거리가 d를 넘는 위치에는 점을 찍지 않는다. 
        
        long count = 0;  
        
        for(long i=0; i<=d; i+=k){
            long y = (long) Math.sqrt((long)d*d - i*i);
            
            count += (y/k)+1; // b의 최대 값에서 +1 경우의 수 누적
        }
        
        return count;
    }
}