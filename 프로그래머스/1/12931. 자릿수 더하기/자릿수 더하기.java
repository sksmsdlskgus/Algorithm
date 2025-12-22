import java.util.*;

public class Solution {
    public int solution(int n) {
        int sum = 0;

        String n_string = Integer.toString(n);
        
        System.out.println(n_string);
        
        for(char n_char: n_string.toCharArray()){
            int n_int = Character.getNumericValue(n_char);
            sum += n_int;
        }
        
        return sum;
    }
}