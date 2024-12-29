import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];

        // commands 배열을 순회
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1]; 
            int k = commands[idx][2];

            System.out.println(result);
            
            // 1. 배열 자르기
            int[] subArray = Arrays.copyOfRange(array, i - 1, j);

            
            Arrays.sort(subArray);

            result[idx] = subArray[k - 1];
        }

        return result;
    }
}
