import java.util.*;

class Solution {
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        Arrays.sort(tickets, Comparator.comparing((String[] a) -> a[0]).thenComparing(a -> a[1]));
        List<String> result = dfs("ICN",new ArrayList<>(),tickets,0);
        
        return result.toArray(new String[0]);
    }
    
    public List<String> dfs(String from, List<String> path,String[][] tickets,int depth){
        path.add(from);
        
        if(depth == tickets.length){
            return new ArrayList<>(path);
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(from)){
                visited[i] = true;
                
                List<String> next = dfs(tickets[i][1],path,tickets,depth +1);
                if(next != null) return next;
                visited[i] = false;
            }
        }
        
        path.remove(path.size()-1);
        
        return null;
    }
}