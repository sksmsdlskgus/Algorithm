import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        // 카펫의 가로, 세로 크기를 담은 배열 return
        // 가로길이는 세로 길이보다 같거나 크다
        // b+y = 총 넓이     
        int resultArea = brown + yellow;
        
        int[] lengths = squareArea(resultArea, yellow);
        
        return lengths;
    }
    
    public int[] squareArea(int area, int yellowLength){
        int[] square = new int[2];
        
        for(int i=3; i<=area; i++){
            int j = area/i;
            
            if(j >=3){
                int x = Math.max(i,j);
                int y = Math.min(i,j);
                
                int center = (x-2)*(y-2);
                
                if(center == yellowLength){
                    square[0] = x;
                    square[1] = y;
                }
                
            }
            
        }
        
        return square;   
    }
}