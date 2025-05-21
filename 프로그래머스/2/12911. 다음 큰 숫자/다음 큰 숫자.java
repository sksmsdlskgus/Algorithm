class Solution {
    public int solution(int n) {
        // 1의 갯수가 같은 가장 작은 수를 구하여라.
        int result = 0;
        long maxNum = Integer.MAX_VALUE;
        String nbinary = Integer.toBinaryString(n);
        
        int ncount = 0;
        for(int i=0; i<nbinary.length(); i++){
            if(nbinary.charAt(i) == '1'){
                ncount++;
            }
        }
        
        for(int i=n+1; i<maxNum; i++){
            String binary = Integer.toBinaryString(i);
            int count = 0; 
            
            for(int j=0; j<binary.length(); j++){
                if(binary.charAt(j) == '1'){
                    count++;
                }
            }
            
            if(ncount == count){
                result = i;
                break;
            }
        }
        
        
        return result;
    }
}