class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;          // arr1의 행
        int m = arr1[0].length;       // arr1의 열 = arr2의 행
        int p = arr2[0].length;       // arr2의 열

        int[][] answer = new int[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
