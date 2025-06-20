import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>();
        
        int even = 0;
        int odd = 0;
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                even++;
            }else{
                odd++;
            }
        }
        
        list.add(even);
        list.add(odd);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}