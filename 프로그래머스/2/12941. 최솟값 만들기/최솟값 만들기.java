import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        // 배열 A를 오름차순으로 정렬
        Arrays.sort(A);

        // 배열 B를 내림차순으로 정렬
        Arrays.sort(B);
        for (int i = 0, j = B.length - 1; i < j; i++, j--) {
            int temp = B[i];
            B[i] = B[j];
            B[j] = temp;
        }

        // 두 배열의 곱을 누적
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[i];
        }

        return answer;
    }
}
