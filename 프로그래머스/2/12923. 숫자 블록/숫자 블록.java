class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];

        for (long i = begin; i <= end; i++) {
            
            if (i == 1) {
                answer[(int)(i - begin)] = 0;
                continue;
            }

            boolean found = false;

            for (long j = 2; j * j <= i; j++) {
                
                if (i % j == 0) {
                    long pair = i / j;

                    if (pair <= 10000000) {
                        answer[(int)(i - begin)] = (int)pair;
                        found = true;
                        break;
                        
                    } else if (j <= 10000000) {
                        answer[(int)(i - begin)] = (int)j;
                        found = true;
                        
                    }
                }
            }

            if (!found) {
                answer[(int)(i - begin)] = 1;
            }
        }

        return answer;
    }
}
