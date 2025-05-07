import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // X의 각 숫자 등장 횟수 카운트
        for (char x : X.toCharArray()) {
            countX[x - '0']++;
        }
        
        // Y의 각 숫자 등장 횟수 카운트
        for (char y : Y.toCharArray()) {
            countY[y - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 9부터 0까지의 숫자 순으로 공통 숫자만큼 추가
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]);
            for (int j = 0; j < common; j++) {
                sb.append(i);
            }
        }
        
        String answer = sb.toString();
        
        // 예외처리
        if (answer.equals("")) return "-1"; 
        if (answer.replaceAll("0", "").equals("")) return "0"; 
        
        return answer;
    }
}
