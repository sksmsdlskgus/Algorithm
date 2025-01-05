import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // phone_book = 전화번호를 담은 배열 
        // 한 번호가 다른 번호의 접두어인 경우가 존재 = false 아니면 true
        Arrays.sort(phone_book);
        
        Map<String,Boolean> map = new HashMap<>();
        for(String phoneNumber : phone_book ){
            map.put(phoneNumber,true);
        }
        
        for(String phoneNumber : phone_book){
            String include = "";
            for(int i=0; i < phoneNumber.length()-1; i++){ // 자기자신 방지
                include += phoneNumber.charAt(i);
                    if(map.containsKey(include)){
                     return false;
              }
            }       
      }
        return true;
    }
}