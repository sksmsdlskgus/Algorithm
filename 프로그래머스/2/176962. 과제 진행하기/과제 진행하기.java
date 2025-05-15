import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        // 멈춘 과제 저장할 스택
        Stack<String[]> stack = new Stack<>();

        Arrays.sort(plans, (a, b) -> toMinute(a[1]) - toMinute(b[1]));

        for (int i = 0; i < plans.length - 1; i++) {
            String name = plans[i][0];
            int startTime = toMinute(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            int nextStartTime = toMinute(plans[i + 1][1]);
            int remainTime = nextStartTime - startTime;

            if (remainTime >= playTime) {
                // 현재 과제를 끝낼 수 있음
                answer.add(name);
                remainTime -= playTime;

                // 멈춘 과제 처리
                while (!stack.isEmpty() && remainTime > 0) {
                    String[] paused = stack.pop();
                    int pausedTime = Integer.parseInt(paused[1]);
                    if (remainTime >= pausedTime) {
                        answer.add(paused[0]);
                        remainTime -= pausedTime;
                    } else {
                        stack.push(new String[]{paused[0], String.valueOf(pausedTime - remainTime)});
                        break;
                    }
                }
            } else {
                // 현재 과제를 다 못하고 멈춰야 함
                stack.push(new String[]{name, String.valueOf(playTime - remainTime)});
            }
        }

        // 마지막 과제는 무조건 끝낼 수 있음
        answer.add(plans[plans.length - 1][0]);

        // 멈춘 과제들 이어서 처리
        while (!stack.isEmpty()) {
            answer.add(stack.pop()[0]);
        }

        return answer.toArray(new String[0]);
    }

    // 시간 문자열을 분으로 변환
    private int toMinute(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
