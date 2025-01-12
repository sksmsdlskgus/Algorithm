import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 뒤에있는 기능이 앞에있는 기능보다 먼저 개발될 수 있음
        // 뒤에있는 기능은 앞에있는 기능이 배포될때 함께 배포됨 
        // 순서대로 -> 선입선출
        // progresses = 작업의 진도
        // speeds = 각 작업의 개발 속도가 적힌 정수배열
        // 각 배포마다 몇개의 기능이 배포 되는지 ? 최종 return
        // 배포는 하루에 한 번 ,하루의 끝에 이루어짐
        // 예를 들어 진도율이 95%인 작업의 개발 속도가 -> 하루에 4%라면 -> 배포는 2일 뒤
        // 100-진도율 / 속도 = 남은 일수 -> 반올림 -> 큐에 담아 
        // 큐에 담고 배포 수 리스트 생성 -> 배포수 카운트 적립
        // 큐가 비지 않았으면-> 앞에 작업부터 스캔 -> 비지않고 앞에꺼가 일수가 작거나 같으면 ++
        // 다돌면 리스트에 담기 -> 최종 배열에 담아 리턴
  
        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++) {
            int day = (int) Math.ceil((100-progresses[i])/ (double)speeds[i]) ;  // 아 더블       
            days.offer(day);
            
          }
        
         List<Integer> result = new ArrayList<>();
        while(!days.isEmpty()){
            int current = days.poll(); // 가장 앞의 작업
            int count = 1;
            
            while (!days.isEmpty() && days.peek() <= current) {
                count++;
                days.poll();
            }
             result.add(count);
        }
       
        
      int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

   
        
        return answer;
    }
}