import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
         // h를 구하기 -> 논문 n편중 h번 이상 인용된 논문이 h편 이상이고, 
        // 나머지 논문이 h번 이하 인용 되었다면 h의 최댓값이  이 과학자의  H-Index값이다.  H-Index를 구해라. 
        // 논문의 인용 횟수를 담은 배열 citations
        // 논문 인용 횟수 배열을 내림차순으로 정렬
        Arrays.sort(citations);
        
        int n = citations.length;
        
        // H-Index를 구하기 위해 반복
        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 H-Index 후보
            if (citations[i] >= h) {
                return h; // 조건 만족 시 H-Index 반환
            }
        }
        
        return 0; // 모든 조건을 만족하지 않을 경우 H-Index는 0
    }
}
