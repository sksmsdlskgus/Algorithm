import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 큐에 작업을 필요한 날짜대로 추가
        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            // 필요한 일수 계산
            int day = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            days.offer(day); // 계산된 일수를 큐에 추가
        }

        // 결과를 담을 리스트
        List<Integer> result = new ArrayList<>();

        // 큐가 비지 않을 때까지 반복
        while (!days.isEmpty()) {
            int current = days.poll(); // 가장 앞의 작업
            int count = 1;

            // 현재 작업보다 빨리 배포될 수 있는 작업이 있다면 함께 배포
            while (!days.isEmpty() && days.peek() <= current) {
                count++;
                days.poll(); // 배포된 작업 제거
            }

            result.add(count); // 배포된 작업 수를 결과에 추가
        }

        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
