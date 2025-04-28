import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words에 있는 단어 중 begin과 차이가 1인 단어를 큐에 넣고, 
        // 그 단어를 방문하여 다음 단어를 찾아가는 방식 -> BFS
        
        // words 안에 target이 포함되어있지 않으면 0을 반환
        if(!Arrays.asList(words).contains(target)){
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        
        Set<String> visited = new HashSet<>();
        visited.add(begin);
        
        int level = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                String currentWord = queue.poll();
                
                for(String word : words){
                    if(!visited.contains(word) && isOneCharDiff(currentWord, word)){
                        if(word.equals(target)){
                            return level + 1;
                        }
                        
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
            level ++;
        }

        return 0;
    }
    
     // 두 단어가 한 글자만 다른지 확인하는 메서드
    private boolean isOneCharDiff (String currentWord, String word){
        int diffCount = 0;
        
        for(int i=0; i<currentWord.length(); i++){
            if(currentWord.charAt(i) != word.charAt(i)){
                diffCount++;
            }
            
            if(diffCount > 1){
                return false;
            }

        }
         return diffCount == 1;
    }
    
}