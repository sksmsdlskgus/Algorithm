import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        System.out.println(Arrays.toString(citations));
        // 논문의 인용 횟수를 담은 배열 citations
        // n = 총 논문 수  -> 5
        // n-h = 나머지 논문 수 k -> 5-h // k+h 는 5보다 작다.
        // h편 = h 이상 인용
        // n-h편 = h 이하 인용 ->  h편 = h + 5 이하 인용
        // h의 최댓값은?
        
        int answer =0; 
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        
        int n = citations.length;
        System.out.println("논문 총 편수 :"+ n);
        
        for (int i=0; i<n; i++){
            // 0 부터 4까지 순회할건데 무엇을 순회 하느냐.
            int h = n- i ;
            System.out.println("현재 논문: " + citations[i] + ", h-index 후보: " + h);
            
            if(citations[i] >= h && n-h <= h){
                System.out.println("조건 만족: " + h);
                answer = h;
                break;
                 
            }
            
        }
      
        return answer;
    }
}
