import java.util.*;

class Solution {
    public int solution(String name) {
        // name = 이름 -> 커서는 A부터 무조건 시작
        // 조이스틱 조작 횟수의 최솟값을 return
        // 위로 가는 횟수: name.charAt(i) - 'A'
        // 아래로 가는 횟수: 'Z' - name.charAt(i) + 1
        // ㅜㅜ 너무 어려엉 ㅜㅜ 이게 뭥야야ㅑ양
        int count = 0;
        int minMove = name.length() - 1; // 최악의 경우 초기화

        // 알파벳 변경 횟수 계산
        for (int i = 0; i < name.length(); i++) {
            int change = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            count += change;
        }

        // 커서 이동 최소값 계산
        for (int i = 0; i < name.length(); i++) {
            int nextIdx = i + 1;
            while (nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }
            // 현재 위치까지 이동한 거리 + 끝에서 돌아오는 거리
            minMove = Math.min(minMove, i + name.length() - nextIdx + Math.min(i, name.length() - nextIdx));
        }

        return count + minMove;
    }
}