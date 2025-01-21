public class Solution {
    public int solution(String s) {
        
        int answer = 0;  
        
        while (!s.isEmpty()) {
            char x = s.charAt(0);  
            int countX = 0;  // x의 개수
            int countOther = 0;  // x가 아닌 다른 문자의 개수

            
            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                if (currentChar == x) {
                    countX++;
                } else {
                    countOther++;
                }

                
                if (countX == countOther) {
                    answer++;
                    s = s.substring(i + 1);  // 분리된 문자열을 제외 ->다음 남은 문자열로 업데이트
                    break;
                }
            }

            // 만약 두 카운트가 같지 않다면 마지막까지 읽고 종료
            if (countX != countOther) {
                answer++;
                break;
            }
        }

        return answer;
    }
}