import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 작업번호, 요청 시각, 작업의 소요 시간 
        // 하드디스크가 작업 x, 대기 큐가 비어있지 x 
        // 우선순위 높은 순 : 소요시간 짧고, 요청시각 빠르고, 작업번호가 작은것
        // 마칠때까지 그 작업만 수행
        // 작업을 마치는 시점과 요청 시점이 겹치면, 요청을 큐에 저장한후 계속 반복
        // 모든 요청에 대한 반환시간의 평균 정수 부분을 return해라 
        // (반환시간 = 종료시각 - 요청시각 )/jobs.length = 평균 반환 시간 
        
        Arrays.sort(jobs,Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]); // 소요시간 빠른순
        int count = 0;
        int index = 0;
        int total = 0;
        int time = 0;
        
        while(count < jobs.length){
            
            while(index <jobs.length && jobs[index][0] <=time){
                pq.offer(jobs[index]);
                index++;
            }
            
            if(!pq.isEmpty()){
                int[] job = pq.poll();
                time += job[1];
                total += time -job[0];
                count++;
            }else {
                time = jobs[index][0];
            }
        }
        
        
        return total/jobs.length;
    }
}