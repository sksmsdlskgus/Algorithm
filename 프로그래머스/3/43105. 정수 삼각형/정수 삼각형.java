class Solution {
    public int solution(int[][] triangle) {
        // 최대값이나 최소값 합계 구하는건 아래에서 위로 접근해보기 
        
        for (int i = triangle.length - 1; 0 < i; i--){
            for (int j = 0; j < triangle[i].length - 1; j++){
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
  

        return triangle[0][0];
    }
}