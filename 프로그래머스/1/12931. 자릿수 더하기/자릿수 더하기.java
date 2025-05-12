import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;
        
        String s = Integer.toString(n);
        String[] sSplit = s.split("");
        for(int i=0; i<sSplit.length; i++){
            int sInt = Integer.parseInt(sSplit[i]);
            sum += sInt;
        }
        
        return sum;
    }
}