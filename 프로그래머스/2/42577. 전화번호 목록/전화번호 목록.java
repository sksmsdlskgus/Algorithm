import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // phone_book = 전화번호를 담은 배열 
        // 한 번호가 다른 번호의 접두어인 경우가 존재 = false 아니면 true
        //String.startsWith() 활용해서 다시.
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i]))
               return false;
        }
        
        return true;
    }
}
