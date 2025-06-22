class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i=1; i<=r2; i++){
            long maxY = (long)Math.floor(Math.sqrt((long)r2*r2 - (long)i*i));
            
            long minY =0;
            
            if(i<r1){
                minY = (long)Math.ceil(Math.sqrt((long)r1*r1 - (long)i*i));
            }
            
            if(maxY >= maxY){
                answer += maxY-minY+1;
            }
        }
        
        return answer * 4;
    }
}