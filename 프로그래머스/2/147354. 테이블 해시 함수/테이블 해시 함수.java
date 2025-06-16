import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        // col 번째 컬럼의 값기준으로 오름차순 정렬. -> 중복값이 있으면 첫번째 컬럼의 값을 기준으로 내림차순 정렬.
        // S_i를 i번째 행의 튜플에 대해 각 컬럼의 값을 %i += 으로 정의
        // 테이블의 해시값을 return해라
        
        int answer = 0;
        
        Arrays.sort(data, (a, b) -> {
            if (a[col - 1] != b[col - 1]) {
                return Integer.compare(a[col - 1], b[col - 1]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });
        
        
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int s_i = 0;
            for (int val : data[i]) {
                s_i += val % (i + 1);
            }
            answer ^= s_i;
        }

        
        return answer;
    }
}