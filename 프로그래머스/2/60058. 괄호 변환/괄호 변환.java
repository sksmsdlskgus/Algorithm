import java.util.*;

class Solution {
    public String solution(String p) {
        // 괄호 개수는 무조건 짝수로 짝개수는 맞음
        // 출력 시, 짝 맞게 출력
        // 만약 p가 이미 올바른 짝이면 그대로 return 
        // 아니면 짝을 맞춰서 return
        // u는 균형잡힌 괄호 문자열로 짝수가 맞으면서 더이상 분리 안돼어야함.
        // v는 빈 문자열 가능
        // 앞에 두개를 꺼냐고 u에 담고 나머지 v에 담아 반복해서 비교 
        // 앞에 두개가 그대로면 그대로 result에 추가 v를 또 다시 나눠서 비교? -> 다시 1단계부터 시ㅏㅈㄱ
        // 앞에 두개가 그대로가 아니면 앞뒤 문자 제거 , 나머지 괄호 방향 뒤집기 (길이가 4?)
        // 앞뒤 제거하고 나머지 괄호뒤집은 뒤, ( 앞에 뒤에 ) 하나씩 추가후 합침 
        // 전꺼랑 이어서 붙여 출력 

        String result = "";
        // 빈 문자열인 경우 처리
        if (p.isEmpty()) return p;

        String u = "", v = "";
        int balance = 0, idx = 0;

        // 1. u와 v를 분리하는 과정
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') balance++;
            else balance--;

            if (balance == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        // 2. u가 균형 잡힌 괄호 문자열인지 확인하고, 아니면 괄호 뒤집기
        balance = 0;
        boolean isCorrect = true;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') balance++;
            else balance--;
            if (balance < 0) {
                isCorrect = false;
                break;
            }
        }
        
        if (balance != 0) isCorrect = false;

        // 3. 올바른 괄호 문자열이면 그대로 두고, 아니면 괄호 뒤집기
        if (isCorrect) {
            result = u + solution(v);  // 재귀적으로 처리
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(");  // '(' 추가
            sb.append(solution(v));  // v에 대해 재귀적으로 처리
            sb.append(")");  // ')' 추가

            // u의 첫 번째와 마지막 괄호를 제외하고 뒤집기
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }
            result = sb.toString();
        }

        return result;
    }
}