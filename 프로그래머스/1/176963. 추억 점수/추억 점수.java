import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> list = new ArrayList<>();       
        Queue<String> q = new LinkedList<>();
 
        for(int i=0; i<photo.length; i++){
            
            String[] array = photo[i];
            for(String a : array){
                q.add(a);
            }
            
            int sum = 0;
            
            while(!q.isEmpty()){
                String s = q.poll();
                
                for(int j=0; j<name.length; j++){      
                    if(s.equals(name[j])){
                        sum += yearning[j];
                    }
                    
                }
            }
            
            list.add(sum);
        }
       
        
        return list.stream().mapToInt(i->i).toArray();
    }
}